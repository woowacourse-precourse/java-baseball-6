package baseball;

import baseball.controller.GameManager;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = GameManager.create();
        gameManager.startGame();

        return;
    }

}
