package baseball;

import baseball.controller.BaseballGameController;

public class Application {

    public static void main(String[] args) {
        BaseballGameController gameController = new BaseballGameController();
        gameController.play();
    }
}
