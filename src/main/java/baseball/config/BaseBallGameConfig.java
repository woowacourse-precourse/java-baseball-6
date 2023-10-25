package baseball.config;

public enum BaseBallGameConfig {

    BASEBALL_NUMBER_SIZE(3),
    BASEBALL_MIN_NUMBER(1),
    BASEBALL_MAX_NUMBER(9),
    BASEBALL_GAME_RESTART(1),
    BASEBALL_GAME_EXIT(2);

    private final int value;

    BaseBallGameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
