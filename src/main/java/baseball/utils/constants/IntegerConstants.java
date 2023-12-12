package baseball.utils.constants;

public enum IntegerConstants {
    MIN_RANGE_NUMBER(1),
    MAX_RANGE_NUMBER(9),
    NUMBERS_SIZE(3);

    private final int value;

    IntegerConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
