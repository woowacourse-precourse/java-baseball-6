package baseball;

import baseball.controller.BaseBallGameController;

public class Application {
    public static void main(String[] args) {
        BaseBallGameController baseBall = new BaseBallGameController();
        baseBall.play();
    }
}
