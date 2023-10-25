package baseball;

import baseball.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = GameController.StartBaseballGame();
        gameController.startGame();
    }
}
