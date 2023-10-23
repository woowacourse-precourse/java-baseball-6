package baseball.controller;

import baseball.domain.*;
import baseball.domain.number.AnswerNumber;
import baseball.domain.number.UserNumber;
import baseball.service.GameService;
import baseball.service.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private GameService gameService;
    private AnswerNumber answerNumber;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = GameService.startNewGame();
        this.answerNumber = createNewAnswer();
    }

    public void run() {
        outputView.printStartMessage();
        while (gameService.isNotDone()) {
            GameResult gameResult = playOneRound(answerNumber);
            outputView.printRoundResult(gameResult);
            if (gameResult.isThreeStrike()) {
                outputView.printSuccess();
                checkRetry();
            }
        }
    }

    private AnswerNumber createNewAnswer() {
        List<Integer> generatedNumber = NumberGenerator.generateNumber();
        return new AnswerNumber(generatedNumber);
    }

    private GameResult playOneRound(AnswerNumber answerNumber) {
        gameService.setCountZero();
        UserNumber userNumber = getUserNumber();
        return gameService.compareNumber(answerNumber, userNumber);
    }

    private UserNumber getUserNumber() {
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
