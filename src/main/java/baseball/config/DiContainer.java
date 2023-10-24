package baseball.config;

import baseball.controller.ComputerController;
import baseball.controller.Controller;
import baseball.controller.UserController;
import baseball.service.GameService;
import baseball.util.Validation;

public class DiContainer {

    public Controller computerController() {
        return new ComputerController();
    }

    public Controller userController() {
        return new UserController(gameService());
    }

    public GameService gameService() {
        return new GameService(validation());
    }

    public Validation validation() {
        return new Validation();
    }
}
