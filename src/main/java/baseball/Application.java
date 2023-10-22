package baseball;

import baseball.controller.GameController;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(outputView(), inputView(), gameSetupService());
        gameController.run();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static GameService gameSetupService() {
        return new GameService();
    }
}
