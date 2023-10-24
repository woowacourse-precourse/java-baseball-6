package baseball.scene;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import baseball.output.StartSceneOutput;

public class StartScene implements Scene {
    private final GameStateManager gameStateManager;
    private final StartSceneOutput startSceneOutput;

    public StartScene(
            final GameStateManager gameStateManager,
            final StartSceneOutput output
    ) {
        this.gameStateManager = gameStateManager;
        this.startSceneOutput = output;
    }

    @Override
    public void run() {
        startSceneOutput.printStartMessage();
        gameStateManager.update(GameState.GAME);
    }
}
