package baseball;

import baseball.configuration.ApplicationConfiguration;
import baseball.controller.GameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationConfiguration appConfig = new ApplicationConfiguration();
        GameManager gameManager = appConfig.gameController();
        gameManager.initialGameStart();
    }
}