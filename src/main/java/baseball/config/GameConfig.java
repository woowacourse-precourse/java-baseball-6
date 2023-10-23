package baseball.config;

public enum GameConfig {
    DIGIT_COUNT(3),
    START_OF_RANGE(1),
    END_OF_RANGE(9);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
