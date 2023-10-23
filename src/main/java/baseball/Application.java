package baseball;

import controller.BaseballController;

public class Application {
    private static final BaseballController baseballController = new BaseballController();
    public static void main(String[] args) {
        baseballController.initGame();
        do {
            baseballController.playGame();
        } while (baseballController.restartGame());
    }
}
