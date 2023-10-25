package baseball.util;

import static baseball.util.GameResults.BALL;
import static baseball.util.GameResults.NOTHING;
import static baseball.util.GameResults.STRIKE;

public class GameResultMessageGenerator {


    public static String makeResultString(int strike, int ball) {

        return makeBallString(ball)
                + makeStrikeString(strike)
                + makeNothingString(strike, ball);
    }

    private static String makeBallString(int ball) {

        if (ball != 0) {
            return ball + BALL;
        }
        return "";
    }

    private static String makeStrikeString(int strike) {

        if (strike != 0) {
            return strike + STRIKE;
        }
        return "";
    }

    private static String makeNothingString(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        return "";
    }
}
