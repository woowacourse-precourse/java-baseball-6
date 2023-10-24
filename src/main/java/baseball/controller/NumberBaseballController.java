package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberBaseballController {

    private static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "서로 다른 수를 입력해주세요.";

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public void run() {
        outputView.printStartMessage();
        int restartNum;
        do {
            playGame();
            restartNum = getRestartNumber();
        } while (restartNum != 2);
    }

    public void playGame() {
        int ballCnt, strikeCnt;
        List<Integer> computerNumbers = makeComputerNumber();

        do {
            List<Integer> userNumbers = getUserNumbers();
            ballCnt = countBallNumber(userNumbers, computerNumbers);
            strikeCnt = countStrikeNumber(userNumbers, computerNumbers);

            outputView.printResult(ballCnt, strikeCnt);
        } while (!isCorrect(strikeCnt));
    }

    public boolean isCorrect(int strikeCnt) {
        return strikeCnt == 3;
    }

    public List<Integer> getUserNumbers() {
        int userNumber = Integer.parseInt(inputView.printInputNumber());
        List<Integer> userNumbers = changeIntToList(userNumber);

        validateDuplicateNumbers(userNumbers); // 중복 값 검증
        return userNumbers;
    }

    public int getRestartNumber() {
        return Integer.parseInt(inputView.printRestartNumber());
    }

    public int countBallNumber(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int count = 0;
        for (Integer userNumber : userNumbers) {
            if(isInSameNumber(computerNumbers, userNumber) && !isInSamePlace(userNumbers, computerNumbers, userNumber))
                count++;
        }
        return count;
    }

    public int countStrikeNumber(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int count = 0;
        for (Integer userNumber : userNumbers) {
            if (isInSamePlace(userNumbers, computerNumbers, userNumber))
                count++;
        }
        return count;
    }

    public boolean isInSameNumber(List<Integer> computerNumbers, int userNumber) {
        return computerNumbers.contains(userNumber);
    }

    public boolean isInSamePlace(List<Integer> userNumbers, List<Integer> computerNumbers, int userNumber) {
        return computerNumbers.indexOf(userNumber) == userNumbers.indexOf(userNumber);
    }

    public void validateDuplicateNumbers(List<Integer> userNumbers) {
        int originSize = userNumbers.size();
        List<Integer> distinctList = userNumbers.stream().distinct().toList();

        if (originSize != distinctList.size())
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
    }

    public List<Integer> changeIntToList(int userNumber) {
        List<Integer> userNumbers = new ArrayList<>();

        while (userNumber > 0) {
            userNumbers.add(userNumber % 10); // if userNumber is 432, userNumbers is in 2,3,4 (reverse)
            userNumber /= 10;
        }

        Collections.reverse(userNumbers); // 2,3,4 -> 4,3,2
        return userNumbers;
    }

    public List<Integer> makeComputerNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }

}
