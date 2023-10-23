package baseball;

import baseball.api.BaseballController;
import baseball.application.BaseballGameService;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(new BaseballGameService());
        baseballController.startBaseball();
    }
}
