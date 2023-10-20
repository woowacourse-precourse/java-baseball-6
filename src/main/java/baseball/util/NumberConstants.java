package baseball.util;

public enum NumberConstants {
    LIMIT_NUMBERS_SIZE(3),
    MIN_RANGE_NUMBER(1),
    MAX_RANGE_NUMBER(9);

    private final int value;

    NumberConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
