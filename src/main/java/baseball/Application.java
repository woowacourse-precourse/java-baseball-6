package baseball;

import baseball.controller.BaseBallController;
import baseball.service.CountService;

public class Application {
    public static void main(String[] args) {
        CountService countService = new CountService();
        BaseBallController baseBallController = new BaseBallController(countService);
        baseBallController.startGame();
    }
}
