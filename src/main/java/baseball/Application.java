package baseball;

import baseball.controller.GameController;
import baseball.service.ComputerService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
