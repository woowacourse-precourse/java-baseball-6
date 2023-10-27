package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BallNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BallNumbers ballNumbers = new BallNumbers();
        BaseballController baseballController = new BaseballController(inputView, outputView,
                ballNumbers);

        baseballController.start();
    }
}
