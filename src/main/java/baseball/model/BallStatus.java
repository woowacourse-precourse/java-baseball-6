package baseball.model;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
