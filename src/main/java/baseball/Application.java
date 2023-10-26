package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = Configuration.baseballController();
        baseballController.start();

        do {
            baseballController.play();
        } while (baseballController.replay());

        baseballController.end();
    }
}
