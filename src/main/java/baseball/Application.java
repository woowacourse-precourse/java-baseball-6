package baseball;

import baseball.config.AppConfig;
import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig config = new AppConfig();
        GameController gameController = config.gameController();
        
        gameController.play();
    }
}