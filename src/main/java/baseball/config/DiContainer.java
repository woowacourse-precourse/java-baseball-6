package baseball.config;

import baseball.controller.ComputerController;
import baseball.controller.UserController;
import baseball.domain.GameService;
import baseball.util.Validation;

public class DiContainer {

    public ComputerController computerController() {
        return new ComputerController();
    }

    public UserController userController() {
        return new UserController(gameService());
    }

    public GameService gameService() {
        return new GameService(validation());
    }

    public Validation validation() {
        return new Validation();
    }
}
