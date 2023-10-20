package baseball;

import baseball.controller.BaseBallGameController;

public class Application {
    public static void main(String[] args) {
        BaseBallGameController baseBallGameController = new BaseBallGameController();
        baseBallGameController.startGame();
    }
}
