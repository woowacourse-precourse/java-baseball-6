package baseball;

public enum GameState {
    CONTINUE(1), GAME_OVER(2), END_POINT(3),;

    private final int value;

    GameState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
