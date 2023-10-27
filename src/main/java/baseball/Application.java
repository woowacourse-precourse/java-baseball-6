package baseball;

import baseball.controller.GameController;
import baseball.domain.BaseballGame;

public class Application {

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        GameController gameController = new GameController(baseballGame);
        gameController.start();
    }
}
