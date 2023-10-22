package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        baseballController.run();
    }
}
