package baseball;

import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseballController baseballController = new BaseballController(inputView, outputView);
        baseballController.startBaseballGame();
    }
}
