package baseball;

import baseball.controller.GameController;
import baseball.util.MessageUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
