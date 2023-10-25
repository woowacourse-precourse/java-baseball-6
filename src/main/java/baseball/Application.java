package baseball;

import baseball.controller.GameController;
import baseball.utils.GameAnswerManager;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new GameAnswerManager());
        gameController.start();
    }
}
