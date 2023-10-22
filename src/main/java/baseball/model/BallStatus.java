package baseball.model;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNothing() {
        return this != BallStatus.NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
