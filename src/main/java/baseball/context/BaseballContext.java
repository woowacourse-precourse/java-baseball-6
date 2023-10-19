package baseball.context;

public class BaseballContext {

    private GameState gameState;

    public BaseballContext() {
        this(GameState.RUNNING);
    }

    public BaseballContext(GameState initialState) {
        this.gameState = initialState;
    }

    public void finish() {
        this.gameState = GameState.FINISH;
    }

    public boolean isRunning() {
        return this.gameState == GameState.RUNNING;
    }
}
