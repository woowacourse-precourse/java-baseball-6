package baseball.view;

import static baseball.util.AppConstants.BALL_MESSAGE;
import static baseball.util.AppConstants.GAME_END_MESSAGE;
import static baseball.util.AppConstants.NOTHING_MESSAGE;
import static baseball.util.AppConstants.START_MESSAGE;
import static baseball.util.AppConstants.STRIKE_MESSAGE;

public class OutputView {
    public static void startGame() {
        System.out.println(START_MESSAGE);
    }

    public static void printResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (ball > 0 && strike > 0) {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
            return;
        }
        if (ball > 0) {
            System.out.println(ball + BALL_MESSAGE);
        }
        if (strike > 0) {
            System.out.println(strike + STRIKE_MESSAGE);
        }
    }
    public static void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }
}