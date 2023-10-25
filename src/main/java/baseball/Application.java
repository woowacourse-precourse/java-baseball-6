package baseball;

import baseball.controller.GameManager;
import baseball.view.GameIO;

public class Application {
    public static void main(String[] args) {
        GameIO gameIO = new GameIO();
        GameManager gameManager = new GameManager(gameIO);
        gameManager.gameStart();
    }
}
