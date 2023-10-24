package baseball.ball;

public enum Result {
    STRIKE,
    BALL,
    NOTHING;

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }
}
