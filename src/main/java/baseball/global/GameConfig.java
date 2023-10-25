package baseball.global;

public enum GameConfig {
    NUMBER_LENGTH(3),
    RANDOM_NUMBER_MINIMUM(1),
    RANDOM_NUMBER_MAXIMUM(9),

    EXIT_FLAG(1),
    RESTART_FLAG(2);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public int getValue() {
        return value;
    }
}
