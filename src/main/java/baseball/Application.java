package baseball;

import baseball.controller.GameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ApplicationConfig appConfig = new ApplicationConfig();
        GameManager gameManager = appConfig.gameController();
        gameManager.initialGameStart();
    }
}