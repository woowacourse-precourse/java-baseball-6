package baseball;

public enum Constant {

    PLAY_NUMBER_DIGIT(3),
    PLAY_WANT(1),
    END_WANT(2),
    START_NUMBER(1),
    END_NUMBER(9);

    private final int value;

    Constant(final int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getValue() {
        return this.value;
    }
}
