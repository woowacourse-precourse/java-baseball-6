package baseball.model;

public enum BallStatus {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private String message;

    BallStatus(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
