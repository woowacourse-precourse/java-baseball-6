package baseball.context;

public class GameLifeCycle {

    private GameState gameState;

    public GameLifeCycle(GameState initialGameState) {
        this.gameState = initialGameState;
    }

    public boolean isRunning() {
        return gameState == GameState.RUNNING;
    }

    public void finish() {
        this.gameState = GameState.FINISH;
    }
}
