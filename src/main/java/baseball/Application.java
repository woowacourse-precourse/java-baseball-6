package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(new InputView(), new OutputView());
        baseballGameController.run();
    }
}
