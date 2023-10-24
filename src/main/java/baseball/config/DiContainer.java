package baseball.config;

import baseball.controller.Controller;
import baseball.controller.UserController;
import baseball.service.GameService;
import baseball.util.Validation;
import baseball.view.InputView;
import baseball.view.OutputVIew;
import baseball.view.View;

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

    public View inputView() {
        return new InputView();
    }

    public OutputVIew outputView() {
        return new OutputVIew();
    }
}
