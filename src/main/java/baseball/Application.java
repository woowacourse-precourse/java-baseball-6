package baseball;

import baseball.game.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.manage();
    }
}
