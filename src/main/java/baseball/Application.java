package baseball;

import baseball.controller.BaseBallGameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseBallGameController.of(
                new InputView(),
                new OutputView()
        ).playGame();
    }
}
