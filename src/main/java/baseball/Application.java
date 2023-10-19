package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();
        GameController baseBallGameController = new GameController(outputView, inputView);
        baseBallGameController.run();
    }

}
