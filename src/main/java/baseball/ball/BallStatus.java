package baseball.ball;

public enum BallStatus {
    STRIKE, NOTHING,BALL;

    public boolean isNothing() {
        return this != BallStatus.NOTHING;
    }
}
