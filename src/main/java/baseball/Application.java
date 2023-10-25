package baseball;

import baseball.util.GameManager;

public class Application {
    public static void main(String[] args) {

        GameManager gameManager = new GameManager();
        gameManager.run();
    }
}
