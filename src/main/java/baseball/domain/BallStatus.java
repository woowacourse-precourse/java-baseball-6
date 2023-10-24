package baseball.domain;

public enum BallStatus {

    BALL(0),
    STRIKE(1),
    NOTHING(2),
    ;

    private final int value;

    BallStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
