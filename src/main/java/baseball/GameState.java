package baseball;

public enum GameState {
    START,
    GAME,
    END,
    EXIT;

    public boolean isInGame() {
        return this == GameState.GAME;
    }
    public boolean isInEnd() {
        return this == GameState.END;
    }
    public boolean isInExit() {
        return this == GameState.EXIT;
    }
}
