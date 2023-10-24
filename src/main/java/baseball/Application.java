package baseball;

import baseball.controller.GameController;
import baseball.controller.RandomNumberUtility;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.game();
    }
}
