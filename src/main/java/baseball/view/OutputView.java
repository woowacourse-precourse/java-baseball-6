package baseball.view;

import static baseball.model.Constant.BALL;
import static baseball.model.Constant.INCORRECT;
import static baseball.model.Constant.STRIKE;

public class OutputView {

    public static void printGuide(String message) {
        System.out.println(message);
    }

    public static void printHint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(INCORRECT);
        } else if (ball > 0 && strike > 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        } else if (ball > 0) {
            System.out.println(ball + BALL);
        } else if (strike > 0) {
            System.out.println(strike + STRIKE);
        }
    }
}
