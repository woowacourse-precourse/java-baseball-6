package baseball;

import baseball.controller.BaseballController;
import baseball.domain.RandomAnswerGenerator;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(new RandomAnswerGenerator(),
                new BaseballInputView(),
                new BaseballOutputView());
        baseballController.run();
    }
}
