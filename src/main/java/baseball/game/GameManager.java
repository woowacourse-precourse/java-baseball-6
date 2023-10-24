package baseball.game;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import baseball.scene.Scene;
import baseball.scene.SceneFactory;
import baseball.scene.SceneManager;

public class GameManager {
    private final GameStateManager gameStateManager;
    private final SceneFactory sceneFactory;
    private final SceneManager sceneManager;

    public GameManager(
            final GameStateManager gameStateManager,
            final SceneManager sceneManager,
            final SceneFactory sceneFactory
    ) {
        this.gameStateManager = gameStateManager;
        this.sceneManager = sceneManager;
        this.sceneFactory = sceneFactory;
    }

    public void loop() {
        initialize();
        while (!gameStateManager.isInExit()) {
            final Scene scene = sceneFactory.createSceneFromGameState();
            sceneManager.load(scene);
        }
    }

    private void initialize() {
        gameStateManager.update(GameState.START);
    }
}
