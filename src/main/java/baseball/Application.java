package baseball;

import baseball.controller.BaseballController;

public class Application {
    private static BaseballController baseballController;

    public static void main(String[] args) {
        baseballController.start();
    }
}
