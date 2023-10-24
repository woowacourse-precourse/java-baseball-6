package baseball;


import baseball.game.GameManager;
import baseball.game.state.GameStateManager;
import baseball.scene.SceneFactory;
import baseball.scene.SceneManager;

public class Application {
    public static void main(final String[] args) {
        final GameStateManager gameStateManager = new GameStateManager();
        final SceneManager sceneManager = new SceneManager();
        final SceneFactory sceneFactory = new SceneFactory(gameStateManager);
        final GameManager gameManager = new GameManager(gameStateManager, sceneManager, sceneFactory);
        gameManager.loop();
    }
}
