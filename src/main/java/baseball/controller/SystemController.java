package baseball.controller;

import baseball.domain.BallCounter;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class SystemController {
    private final InputView inputView;

    private final OutputView outputView;

    private final GameController gameController;

    private final GameService gameService;

    public SystemController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.gameController = new GameController(inputView, outputView);
        this.gameService = new GameService();
    }

    public void run() {
        boolean continueGame = true;
        while (continueGame) {
            BallCounter ballCounter = new BallCounter(0, 0);
            inputView.generateGameStartMessage();
            gameController.tryOnce(gameService.generateComputerNumbers(), ballCounter);
            outputView.showGameEndMessage();
            inputView.showRetryOrEndGameMessage();
            continueGame = gameController.retryOrExit();
        }
    }
}
