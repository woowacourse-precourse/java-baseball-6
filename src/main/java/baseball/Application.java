package baseball;

import baseball.controller.GameController;
import baseball.controller.InputController;
import baseball.service.BallGeneratorService;
import baseball.service.GameService;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(inputController(), outputView(), gameService(), ballGeneratorService());
        gameController.run();
    }

    private static InputController inputController() {
        return new InputController();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static GameService gameService() {
        return new GameService();
    }

    private static BallGeneratorService ballGeneratorService() {
        return new BallGeneratorService();
    }
}
