package baseball;

import baseball.Controller.BaseballController;

public class Application {

    private static final BaseballController baseballController = new BaseballController();

    public static void main(String[] args) {

        baseballController.startGame();
    }
}
