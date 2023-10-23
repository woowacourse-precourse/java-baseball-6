package baseball.common;

public enum Number {
    NUMBER_LENGTH(3),
    NUMBER_RANGE_MIN(1),
    NUMBER_RANGE_MAX(9);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
