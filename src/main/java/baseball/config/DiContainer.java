package baseball.config;

import baseball.controller.Controller;
import baseball.controller.UserController;
import baseball.service.GameService;
import baseball.util.Validation;
import baseball.view.InputView;
import baseball.view.View;

public class DiContainer {

    public Controller userController() {
        return new UserController(inputView(), gameService());
    }

    public GameService gameService() {
        return new GameService(validation());
    }

    public Validation validation() {
        return new Validation();
    }

    public View inputView() {
        return new InputView();
    }
}
