package baseball;

import baseball.controller.GameController;
import baseball.controller.ViewController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new ViewController(new InputView(), new OutputView()));
        gameController.start();
    }
}
