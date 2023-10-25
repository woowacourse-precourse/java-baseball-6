package baseball;

import baseball.manager.GameManager;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfiguration appConfiguration = new AppConfiguration();
        GameManager gameManager = appConfiguration.gameManager();

        gameManager.play();
    }
}
