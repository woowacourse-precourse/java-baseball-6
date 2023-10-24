package baseball;

import baseball.Controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        baseballController.gameStart();
    }
}
