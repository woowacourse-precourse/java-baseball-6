package baseball.config;

public enum NumberConfig {
    NUMBER_LENGTH(3);

    private final int value;

    NumberConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
