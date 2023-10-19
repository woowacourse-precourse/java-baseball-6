package baseball.domain;

public enum BallStatus {

    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private final String status;

    BallStatus(String status) {
        this.status = status;
    }
}