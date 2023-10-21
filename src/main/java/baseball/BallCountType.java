package baseball;

/**
 * 볼카운트에 따른 경우의 수
 */
public enum BallCountType {

    STRIKEOUT(true, false),
    ONLY_BALL(false, true),
    ONLY_STRIKE(true, false),
    STRIKE_AND_BALL(true, true),
    NOTHING(false, false),
    ;

    BallCountType(boolean hasStrike, boolean hasBall) {
    }

}
