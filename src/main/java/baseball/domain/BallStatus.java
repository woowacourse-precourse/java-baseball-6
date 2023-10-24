package baseball.domain;

public enum BallStatus {
    BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

    private final String message;

    BallStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
