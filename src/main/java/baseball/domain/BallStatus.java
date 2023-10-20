package baseball.domain;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
