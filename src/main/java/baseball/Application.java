package baseball;

import baseball.controller.BaseballController;
import baseball.domain.BallNumber;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BaseballService baseballService = new BaseballService();
        BallNumber ballNumber = new BallNumber();
        BaseballController baseballController = new BaseballController(inputView, outputView, baseballService,
                ballNumber);

        baseballController.start();
    }
}
