package utils;

import player.BaseballNumbers;

public class BaseballRules {

    public static boolean isThreeStrike(BaseballNumbers playerBaseballNumber,
                                        BaseballNumbers computerBaseballNumber) {
        return playerBaseballNumber.equals(computerBaseballNumber);
    }

    public static boolean hasStrikeAndBall(int strike, int ball) {
        return strike > 0 && ball > 0;
    }

    public static boolean hasStrikeButNoBall(int strike, int ball) {
        return strike > 0 && ball == 0;
    }

    public static boolean hasBallButNoStrike(int strike, int ball) {
        return ball > 0 && strike == 0;
    }

    public static boolean noStrikeAndBall(int strike, int ball) {
        return strike == 0 && ball == 0;
    }
}
