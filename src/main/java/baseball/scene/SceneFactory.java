package baseball.scene;

import baseball.game.state.GameStateManager;
import baseball.input.GameOverSceneInput;
import baseball.input.GameSceneInput;
import baseball.output.GameOverSceneOutput;
import baseball.output.GameSceneOutput;
import baseball.output.StartSceneOutput;

public class SceneFactory {
    private final GameStateManager gameStateManager;

    public SceneFactory(final GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public Scene createSceneFromGameState() {
        if (gameStateManager.isInStart()) {
            return new StartScene(gameStateManager, new StartSceneOutput());
        }

        if (gameStateManager.isInGame()) {
            return new GameScene(gameStateManager, new GameSceneInput(), new GameSceneOutput());
        }

        if (gameStateManager.isInGameOver()) {
            return new GameOverScene(gameStateManager, new GameOverSceneInput(), new GameOverSceneOutput());
        }

        if (gameStateManager.isInExit()) {
            return new ExitScene();
        }

        throw new IllegalArgumentException("해당하는 Scene 이 없습니다.");
    }
}
