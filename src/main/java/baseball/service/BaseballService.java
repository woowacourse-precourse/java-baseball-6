package baseball.service;

import baseball.view.OutputView;
import java.util.Objects;

public class BaseballService {
    private final OutputView outputView = new OutputView();

    public boolean startGame(String randomNumber, String input) {
        int strike = countStrike(randomNumber, input);
        int ball = countBall(randomNumber, input);

        if (strike == 3) {
            outputView.printThreeStrike(strike);
            return false;
        } else {
            printResult(strike, (ball - strike));
            return true;
        }
    }

    public int countStrike(String randomNumber, String input) {
        int count = 0;
        for (int size = 0; size < 3; size++) {
            if (Objects.equals(randomNumber.charAt(size), input.charAt(size))) {
                count++;
            }
        }
        return count;
    }

    public int countBall(String randomNumber, String input) {
        int count = 0;
        for (int size = 0; size < 3; size++) {
            String number = String.valueOf(randomNumber.charAt(size));
            if (input.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            outputView.noStrikeNoBall();
        } else if (strike == 0) {
            outputView.printBall(ball);
        } else if (ball == 0) {
            outputView.printStrike(strike);
        } else {
            outputView.printStrikeAndBall(strike, ball);
        }
    }
}
