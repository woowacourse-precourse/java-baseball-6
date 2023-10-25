package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    private static final int MAX_SIZE = 3;
    private static final int VALID = 1;

    public void proceedGame() {
        OutputView.printStartGameMsg();

        int gameStatus = VALID;
        while (gameStatus == VALID) {
            List<Integer> computerNumbers = chooseRandomNumbers();

            boolean isCorrect = false;
            while (!isCorrect) {
                OutputView.printGetUserNumbersMsg();
                int userNumbers = InputView.getUserNumbers();
                isCorrect = checkNumbers(computerNumbers, userNumbers);
            }

            OutputView.printEndGameMsg();
            gameStatus = InputView.getRestart();
        }
    }

    private List<Integer> chooseRandomNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();

        while (computerNumbers.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }

        return computerNumbers;
    }

    private boolean checkNumbers(List<Integer> computerNumbers, int userNumbers) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < MAX_SIZE; i++) {
            int compareNumber = userNumbers / (int) Math.pow(10, 2 - i);
            userNumbers %= (int) Math.pow(10, 2 - i);
            if (!computerNumbers.contains(compareNumber)) {
                continue;
            }
            if (computerNumbers.indexOf(compareNumber) == i) {
                strikes += 1;
            } else {
                balls += 1;
            }
        }

        OutputView.printBaseballResult(balls, strikes);

        return strikes == MAX_SIZE;
    }
}
