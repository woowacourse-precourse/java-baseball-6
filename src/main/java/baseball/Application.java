package baseball;

import baseball.controller.BaseballGameController;
import baseball.service.BaseballGameService;
import baseball.utils.PrintUtils;

public class Application {
    public static void main(String[] args) {
        BaseballGameService baseballGameService = new BaseballGameService();
        BaseballGameController baseballGameController = new BaseballGameController(baseballGameService);
        PrintUtils.printStartGame();
        baseballGameController.start();

    }
}
