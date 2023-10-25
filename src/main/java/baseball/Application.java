package baseball;

import baseball.contoller.BaseballController;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController();
        baseballController.startGame();
    }
}
