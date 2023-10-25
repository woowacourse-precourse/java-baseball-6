package baseball;

import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        final BaseballGameController baseballGameController = new BaseballGameController();
        baseballGameController.run();
    }
}