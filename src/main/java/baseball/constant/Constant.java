package baseball.constant;

public enum Constant {

    START_INCLUSIVE(1),
    END_INCLUSIVE(9),
    BASEBALL_GAME_NUMBER_DIGIT(3);

    private final int value;

    Constant(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
