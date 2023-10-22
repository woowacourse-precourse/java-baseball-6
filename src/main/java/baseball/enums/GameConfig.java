package baseball.enums;

public enum GameConfig {
    BALL_COUNT(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9),
    GAME_CONTINUE(1),
    GAME_EXIT(2);

    private final int value;

    GameConfig(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
