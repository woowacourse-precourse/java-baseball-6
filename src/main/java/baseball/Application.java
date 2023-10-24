package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();
        BaseballGameController baseballGameController = new BaseballGameController(inputView, outputView);
        baseballGameController.gameStart();
    }
}
