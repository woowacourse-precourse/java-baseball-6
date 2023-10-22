package baseball;

public enum BallStatus {
    STRIKE("스트라이크"),
    BALL("볼 "),
    NOTHING("낫싱");

    private final String ballStatus;

    BallStatus(String ballStatus) {
        this.ballStatus = ballStatus;
    }

    public String getBallStatus() {
        return ballStatus;
    }
}
