package baseball.domain;

public enum BallStatus {
    STRIKE,
    BALL,
    NONE;

    @Override
    public String toString() {
        return "BallStatus{" +
                "name=" + name() +
                '}';
    }
}
