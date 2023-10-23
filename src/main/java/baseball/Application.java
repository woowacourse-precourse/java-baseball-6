package baseball;

import baseball.controller.BaseballGameController;

public class Application {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        BaseballGameController baseballGameController = appConfig.baseballGameController();

        baseballGameController.playBaseballGame();
    }
}