package baseball.controller;

import baseball.domain.RoundResult;
import baseball.service.BaseballService;
import baseball.view.console.InputView;
import baseball.view.console.OutputView;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
    }

    public void printGameStartMessage() {
        outputView.printGameStartMessage();
    }

    public void playGame() {
        baseballService.startNewGame();
        repeatRoundUntilCorrect();
        outputView.printGameEndMessage();
    }

    private void repeatRoundUntilCorrect() {
        while (true) {
            String guessedNumbers = inputView.readGuessedNumber();
            RoundResult roundResult = baseballService.playRoundWithGuess(guessedNumbers);
            outputView.printRoundResult(roundResult.toString());

            if (roundResult.isCorrect()) {
                break;
            }
        }
    }

    public boolean isRetry() {
        String command = inputView.readCommand();
        return baseballService.isRetry(command);
    }
}
