package baseball;

import game.GameManager;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        GameManager gameManager = new GameManager();
        gameManager.init();
    }
}
