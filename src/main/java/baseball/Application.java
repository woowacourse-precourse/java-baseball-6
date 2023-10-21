package baseball;

import baseball.controller.BaseballController;
import baseball.domain.RandomAnswerGenerator;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(new RandomAnswerGenerator());
        baseballController.run();
    }
}
