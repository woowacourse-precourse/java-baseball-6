package baseball.controller;

import baseball.domain.GameNumber;
import baseball.domain.GameResult;
import baseball.domain.RetryCommand;
import baseball.service.GameService;
import baseball.service.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private GameService gameService;
    private GameNumber answerNumber;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = GameService.startNewGame();
        this.answerNumber = createNewAnswer();
    }

    public void run() {
        outputView.printStartMessage();
        while (gameService.isNotDone()) {
            gameService.resetResult();
            GameResult gameResult = playOneRound(answerNumber);
            outputView.printRoundResult(gameResult);
            if (gameResult.isThreeStrike()) {
                outputView.printSuccess();
                checkRetry();
            }
        }
    }

    private GameNumber createNewAnswer() {
        List<Integer> generatedNumber = NumberGenerator.generateNumber();
        return new GameNumber(generatedNumber);
    }

    private GameResult playOneRound(GameNumber answerNumber) {
        GameNumber userNumber = getUserNumber();
        return gameService.compareNumber(answerNumber, userNumber);
    }

    private GameNumber getUserNumber() {
        return inputView.getUserNumber();
    }

    private void checkRetry() {
        RetryCommand command = inputView.getRetryCommand();
        if (command.isRetry()) {
            answerNumber = createNewAnswer();
            gameService = GameService.startNewGame();
        }
    }
}
