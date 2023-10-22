package baseball;

public enum NumberLimits {
    NUM_LIST_LENGTH(3),
    MIN_VALUE(1),
    MAX_VALUE(9);
    private final int value;

    NumberLimits(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
