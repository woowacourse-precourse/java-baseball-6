package baseball.game.state;

public class GameStateManager {
    private GameState gameState;

    public GameStateManager() {
        this.gameState = GameState.START;
    }

    public void update(final GameState gameState) {
        this.gameState = gameState;
    }

    public boolean isInStart() {
        return gameState == GameState.START;
    }

    public boolean isInGame() {
        return gameState == GameState.GAME;
    }

    public boolean isInGameOver() {
        return gameState == GameState.GAME_OVER;
    }

    public boolean isInExit() {
        return gameState == GameState.EXIT;
    }
}
