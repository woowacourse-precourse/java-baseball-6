package baseball;

import baseball.config.AppConfig;
import baseball.controller.GameController;

public class Application {

    public static void main(String[] args) {

        GameController gameController = AppConfig.setup();
        gameController.run();
    }
}
