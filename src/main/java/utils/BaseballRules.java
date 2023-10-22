package utils;

import static constant.BaseballConstant.THREE;

public class BaseballRules {

    private final static int ZERO = 0;

    private BaseballRules() {
    }

    public static boolean isThreeStrike(int strike) {
        return strike == THREE;
    }

    public static boolean hasStrikeAndBall(int strike, int ball) {
        return strike > ZERO && ball > ZERO;
    }

    public static boolean hasStrikeButNoBall(int strike, int ball) {
        return strike > ZERO && ball == ZERO;
    }

    public static boolean hasBallButNoStrike(int strike, int ball) {
        return ball > ZERO && strike == ZERO;
    }

    public static boolean noStrikeAndBall(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
}
