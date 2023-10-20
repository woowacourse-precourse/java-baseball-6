package baseball.controller;

import baseball.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberBaseballController {

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final Validator validator = new Validator();

    public void run() {
        int restartNum = 1;
        outputView.printStartMessage();
        while (restartNum != 2) {
            playGame();
            restartNum = getRestartNumber();
        }
    }

    public void playGame() {
        int ballCnt, strikeCnt;
        List<Integer> computerNumbers = makeComputerNumber();
        List<Integer> userNumbers;

        do {
            userNumbers = getUserNumbers();
            ballCnt = countBallNumber(userNumbers, computerNumbers);
            strikeCnt = countStrikeNumber(userNumbers, computerNumbers);

            outputView.printResult(ballCnt, strikeCnt);
        } while (!isCorrect(strikeCnt));
    }

    public boolean isCorrect(int strikeCnt) {
        return strikeCnt == 3;
    }

    public List<Integer> getUserNumbers() {
        int userNumber = inputView.printInputNumber();
        List<Integer> userNumbers = chageIntToList(userNumber);

        validator.isThreeDigit(userNumbers);
        validator.isNotInSameNumber(userNumbers);

        return userNumbers;
    }

    public int getRestartNumber() {
        int restartNum = inputView.printRestartNumber();
        validator.isOneOrTwo(restartNum);
        return restartNum;
    }

    public int countBallNumber(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int count = 0;
        for (Integer userNumber : userNumbers) {
            if(isInSameNumber(computerNumbers, userNumber) && !isInSamePlace(userNumbers, computerNumbers, userNumber)) // 같은 수는 있으나 같은 자리이면 안됨
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

    public List<Integer> chageIntToList(int userNumber) {
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
