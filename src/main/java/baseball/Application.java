package baseball;

import baseball.application.GameManager;

public class Application {
    public static void main(String[] args) {
        final GameManager gameManager = new GameManager();
        gameManager.run();
    }
}
