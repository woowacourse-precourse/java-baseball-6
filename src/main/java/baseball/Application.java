package baseball;

import baseball.controller.BaseBallController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallController baseBallController = new BaseBallController(new InputView(), new OutputView());
        baseBallController.run();
    }
}
