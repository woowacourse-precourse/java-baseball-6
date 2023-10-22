package baseball.view;

import static baseball.model.constants.Constant.BALL;
import static baseball.model.constants.Constant.GAME_START_PHRASE;
import static baseball.model.constants.Constant.NOTHING;
import static baseball.model.constants.Constant.STRIKE;

public class OutputView {
    public static void printGameStart() {
        System.out.println(GAME_START_PHRASE);
    }

    public static void printCount(int count) {
        System.out.print(count);
    }

    public static void printBall() {
        System.out.print(BALL);
    }

    public static void printBallStrike() {
        System.out.print(BALL + " ");
    }

    public static void printStrike() {
        System.out.print(STRIKE);
    }

    public static void printNothing() {
        System.out.print(NOTHING);
    }
}
