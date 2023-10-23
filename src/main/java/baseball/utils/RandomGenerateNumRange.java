package baseball.utils;

public enum RandomGenerateNumRange {
    START_RANGE_GENERATE_NUM(1),
    END_RANGE_GENERATE_NUM(9),
    COUNT(3);

    private final int value;

    RandomGenerateNumRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
