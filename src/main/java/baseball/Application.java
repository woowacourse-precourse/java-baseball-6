package baseball;

import baseball.controller.BaseballController;

public class Application {

    private static final BaseballController baseballController = new BaseballController();

    public static void main(String[] args) {
        baseballController.start();
    }
}
