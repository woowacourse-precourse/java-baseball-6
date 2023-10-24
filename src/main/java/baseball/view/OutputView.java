package baseball.view;

import static baseball.consts.MessageConst.BALL;
import static baseball.consts.MessageConst.GAME_END_MESSAGE;
import static baseball.consts.MessageConst.GAME_START_MESSAGE;
import static baseball.consts.MessageConst.NOTHING;
import static baseball.consts.MessageConst.STRIKE;

public class OutputView {

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printBallAndStrike(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING);
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + BALL);
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + STRIKE);
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
    }

    public static void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

}
