package baseball.model;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

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
