package baseball;

import baseball.api.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        baseballController.startBaseball();
    }
}
