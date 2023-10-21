package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.service.PlayerService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new GameService(), new PlayerService());
        gameController.startGame();
    }
}
