package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.gameStart();
    }
}
