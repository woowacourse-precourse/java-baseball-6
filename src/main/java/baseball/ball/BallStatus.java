package baseball.ball;

public enum BallStatus {
    STRIKE, NOTHING,BALL;

    public boolean isNotNothing() {
        return this != BallStatus.NOTHING;
    }

    public boolean isStrike() {
        return this == BallStatus.STRIKE;
    }
    public boolean isBall() {
        return this == BallStatus.BALL;
    }
}
