package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.GameStatus;
import baseball.domain.RetryCommand;
import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private GameService gameService;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = GameService.startNewGame();
    }

    public void run() {
        outputView.printStartMessage();
        while (gameService.isNotDone()) {
            gameService.resetStatus();
            GameStatus gameStatus = playOneRound();
            outputView.printRoundResult(gameStatus);
            if (gameStatus.isThreeStrike()) {
                outputView.printSuccess();
                checkRetry();
            }
        }
    }

    private GameStatus playOneRound() {
        GameNumber userNumber = getUserNumber();
        return gameService.compareNumber(userNumber);
    }

    private GameNumber getUserNumber() {
        return inputView.getUserNumber();
    }

    private void checkRetry() {
        RetryCommand command = inputView.getRetryCommand();
        if (command.isRetryCommand()) {
            gameService = GameService.startNewGame();
        }
    }
}
