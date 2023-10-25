package baseball.config;

import baseball.controller.Controller;
import baseball.controller.UserController;
import baseball.service.GameService;
import baseball.util.Validation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class DiContainer {

    public Controller userController() {
        return new UserController(inputView(), gameService());
    }

    public GameService gameService() {
        return new GameService(validation(), outputView());
    }

    public Validation validation() {
        return new Validation();
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}
