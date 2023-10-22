package baseball;

import baseball.controller.BaseBallGameController;
import baseball.service.BaseBallGameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGameController baseBallGameController = new BaseBallGameController();

        baseBallGameController.run();
    }
}
