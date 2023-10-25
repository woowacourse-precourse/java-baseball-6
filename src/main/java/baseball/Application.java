package baseball;

import baseball.controller.GameController;
import baseball.service.ComputerService;
import baseball.service.GameService;
import baseball.service.UserService;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new ComputerService(), new GameService(), new UserService());
        gameController.run();
    }
}
