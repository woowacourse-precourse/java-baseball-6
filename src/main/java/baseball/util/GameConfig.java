package baseball.util;

public enum GameConfig {
    RANDOM_MIN_VALUE(1),
    RANDOM_MAX_VALUE(9),
    GAME_NUM_SIZE(3);

    private int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
