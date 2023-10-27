package baseball;

import baseball.controller.GameController;
import baseball.domain.BaseballGame;
import baseball.domain.Game;

public class Application {

    public static void main(String[] args) {
        Game baseballGame = new BaseballGame();
        GameController gameController = new GameController(baseballGame);
        gameController.start();
    }
}
