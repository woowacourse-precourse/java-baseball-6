package baseball;

public enum GameConfig {
    MIN_NUMBER(1),
    MAX_NUMBER(9),
    BALLS_SIZE(3),
    SUCCESS_STRIKE_COUNT(3),
    ZERO(0);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
