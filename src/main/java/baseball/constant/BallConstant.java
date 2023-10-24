package baseball.constant;

public enum BallConstant {

    BALL_LENGTH(3),
    MAX_NUMBER(9),
    MIN_NUMBER(1);

    private final int value;

    BallConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
