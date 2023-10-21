package baseball.config;

public enum NumberConfig {
    NUMBER_LENGTH(3),
    NUMBER_MINIMUM_INCLUSIVE(1),
    NUMBER_MAXIMUM_INCLUSIVE(9);

    private final int value;

    NumberConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
