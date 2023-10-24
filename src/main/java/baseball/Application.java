package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;

public class Application {

    public static void main(String[] args) {
        GameService gameService = new GameService();
        GameController gameController = new GameController(gameService);
        gameController.run();
    }
}
