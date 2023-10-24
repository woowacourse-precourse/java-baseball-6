package baseball.scene;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import baseball.input.GameOverSceneInput;
import baseball.output.GameOverSceneOutput;

public class GameOverScene implements Scene {
    private final GameStateManager gameStateManager;
    private final GameOverSceneInput input;
    private final GameOverSceneOutput output;

    public GameOverScene(
            final GameStateManager gameStateManager,
            final GameOverSceneInput input,
            final GameOverSceneOutput output
    ) {
        this.gameStateManager = gameStateManager;
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        output.printEndMessage();

        while (gameStateManager.isInGameOver()) {
            final String userInput = input.getUserInput();
            GameOverCommand.updateFromUserInput(gameStateManager, userInput);
        }
    }
}
