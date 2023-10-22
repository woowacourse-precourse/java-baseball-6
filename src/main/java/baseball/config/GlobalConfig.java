package baseball.config;

public enum GlobalConfig {
    NUMBER_LENGTH(3),
    RANDOM_NUMBER_MINIMUM(1),
    RANDOM_NUMBER_MAXIMUM(9),
    GAME_RESTART_FLAG(2);

    private final int value;

    GlobalConfig(int value) {
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
