package baseball;

import baseball.config.BaseballGameConfig;
import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameController baseballGameController = BaseballGameConfig.baseballGameController;

        baseballGameController.playBaseballGame();
    }
}
