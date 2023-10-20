package baseball;

import baseball.controller.GameController;
import baseball.service.GameLogicService;
import baseball.service.GameResultService;
import baseball.service.GameSetupService;
import baseball.view.console.InputView;
import baseball.view.console.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(outputView(), inputView(), gameSetupService(), gameLogicService(), gameResultService());
        gameController.run();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static InputView inputView() {
        return new InputView();
    }

    private static GameSetupService gameSetupService() {
        return new GameSetupService();
    }

    private static GameLogicService gameLogicService() {
        return new GameLogicService();
    }

    private static GameResultService gameResultService() {
        return new GameResultService();
    }
}
