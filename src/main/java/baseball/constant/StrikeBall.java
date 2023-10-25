package baseball.constant;

public enum StrikeBall {
    STRIKE,
    BALL,
    NONE;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
