package baseball;

import baseball.controller.NumberBaseBallController;

public class Application {

    public static void main(String[] args) {
        NumberBaseBallController numberBaseBallController = new NumberBaseBallController();
        numberBaseBallController.startGame();
    }
}
