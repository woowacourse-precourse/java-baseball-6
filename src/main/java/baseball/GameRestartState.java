package baseball;

public enum GameRestartState {
    GAME_CONTINUE("1"),
    GAME_STOP("2");

    String gameState;

    GameRestartState(String gameState) {
        this.gameState = gameState;
    }

    public String getGameState() {
        return gameState;
    }
}
