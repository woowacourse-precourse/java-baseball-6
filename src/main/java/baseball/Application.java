package baseball;

import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final BaseballController baseballController = new BaseballController();
        baseballController.play();
    }
}
