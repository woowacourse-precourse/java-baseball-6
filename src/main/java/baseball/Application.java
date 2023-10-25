package baseball;

import baseball.controller.BaseBallController;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseBallController baseBallController = new BaseBallController(new BaseballService(), new InputView(),
            new OutputView());
        baseBallController.run();
    }
}
