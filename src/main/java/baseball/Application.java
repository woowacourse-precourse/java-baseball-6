package baseball;

import baseball.controller.GameController;
import baseball.service.ComputerService;

public class Application {
    public static void main(String[] args) {
        ComputerService computerService = new ComputerService();
        GameController gameController = new GameController(computerService);
        gameController.startGame();
    }
}
