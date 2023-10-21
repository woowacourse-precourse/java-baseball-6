package baseball.controller;

import baseball.domain.BallCounter;
import baseball.domain.GameOption;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
        BallCounter ballCounter = new BallCounter(0, 0);
        inputView.generateGameStartMessage();
        gameController.tryOnce(gameService.generateComputerNumbers(), ballCounter);
        outputView.showGameEndMessage();
        inputView.showRetryOrEndGameMessage();
        if (retryOrExit()) run();
    }

    private boolean retryOrExit() {
        String data = readLine();
        if (data.equals(GameOption.RESTART.getOption())) {
            return true;
        }
        if (data.equals(GameOption.END.getOption())) {
            return false;
        }
        return false;
    }
}
