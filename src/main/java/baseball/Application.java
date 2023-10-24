package baseball;

import baseball.domain.controller.BaseballGameController;
import baseball.domain.service.BaseballGameService;

public class Application {
    public static void main(String[] args) {
        BaseballGameService baseballGameService = new BaseballGameService();
        BaseballGameController baseballGameController = new BaseballGameController(baseballGameService);
        baseballGameController.start();
    }
}
