package baseball.scene;

public class SceneManager {
    private Scene currentScene = null;

    public SceneManager() {
        // Empty
    }

    public void load(final Scene scene) {
        this.currentScene = scene;
        scene.run();
    }
}
