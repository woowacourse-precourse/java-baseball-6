package baseball.view;

import static baseball.model.Message.BALL;
import static baseball.model.Message.CORRECT;
import static baseball.model.Message.INCORRECT;
import static baseball.model.Message.STRIKE;
import static baseball.model.NumberRule.NUMBER_SIZE;

public class OutputView {

    public void printGame(String message) {
        System.out.println(message);
    }

    public void printHint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(INCORRECT.getMessage());
        } else if (strike == NUMBER_SIZE.getNumber()) {
            System.out.println(CORRECT.getMessage());
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + BALL.getMessage() + " " + strike + STRIKE.getMessage());
        } else if (ball > 0) {
            System.out.println(ball + BALL.getMessage());
        } else if (strike > 0) {
            System.out.println(strike + STRIKE.getMessage());
        }
    }
}
