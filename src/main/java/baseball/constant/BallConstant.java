package baseball.constant;

public enum BallConstant {

    BALL_LENGTH(3);

    private final int value;

    BallConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
