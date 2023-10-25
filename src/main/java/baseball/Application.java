package baseball;

import baseball.controller.NBGameController;

public class Application {

    public static void main(String[] args) {
        NBGameController gameController = new NBGameController();
        gameController.run();
    }
}
