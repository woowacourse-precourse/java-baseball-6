package baseball;

import baseball.controller.GameController;
import baseball.domain.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new Game());
        gameController.startGame();

        while (true) {
            gameController.playGame();

            if (gameController.restartGame())
                break;
        }

    }
}
