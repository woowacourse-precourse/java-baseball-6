package baseball;

import baseball.application.GameManager;
import baseball.infrastructure.Factory;

public class Application {
    private final GameManager gameManager;

    public Application(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Factory factory = new Factory();
        GameManager gameManager = factory.gameManager();
        Application application = new Application(gameManager);

        application.gameManager.run();
    }

}
