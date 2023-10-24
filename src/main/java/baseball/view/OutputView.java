package baseball.view;

import static baseball.enums.ScoreMessage.BALL;
import static baseball.enums.ScoreMessage.NOTHING;
import static baseball.enums.ScoreMessage.STRIKE;

public class OutputView {
    private static final int NO_COUNT = 0;

    public static void print(String string) {
        System.out.print(string);
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void printScore(int ball, int strike) {
        if ((ball != NO_COUNT) && (strike != NO_COUNT)) {
            println(ball + BALL.getMessage() + " " + strike + STRIKE.getMessage());
        } else if (ball != NO_COUNT) {
            println(ball + BALL.getMessage());
        } else if (strike != NO_COUNT) {
            println(strike + STRIKE.getMessage());
        } else if ((ball == NO_COUNT) && (strike == NO_COUNT)) {
            println(NOTHING.getMessage());
        }
    }
}
