package baseball;

import baseball.config.AppConfig;
import baseball.controller.GameController;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        GameController gameController = appConfig.gameController();
        gameController.run();
    }
}
