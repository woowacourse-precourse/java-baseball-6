package baseball;

import baseball.controller.GameController;
import baseball.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = OutputView.getInstance();
        GameController baseBallGameController = new GameController(outputView);
        baseBallGameController.run();
    }

}
