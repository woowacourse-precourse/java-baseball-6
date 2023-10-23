package baseball;

import baseball.controller.GameManager;

public class Application {
    public static GameManager gameManager;
    public static void main(String[] args) {
        gameManager = new GameManager();
        gameManager.startGame();
    }
}
