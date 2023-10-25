package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballController baseballController = new BaseballController(new BaseballService());
        baseballController.start();
    }
}
