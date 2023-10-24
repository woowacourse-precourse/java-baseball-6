package baseball;

import baseball.controller.BaseballController;
import baseball.domain.RandomBaseballNumbersGenerator;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(new RandomBaseballNumbersGenerator(),
                new BaseballInputView(),
                new BaseballOutputView());
        baseballController.run();
    }
}
