package baseball;

import baseball.controller.BaseballController;
import baseball.io.OutputView;

public class Application {
    public static void main(String[] args) {
        final BaseballController baseballController = new BaseballController(new OutputView());
        baseballController.run();
    }
}
