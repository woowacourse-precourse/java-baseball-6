package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.domain.Hint;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameService {
    private final OutputView outputView;
    private final InputView inputView;
    private static final int CONTINUE_GAME = 1;
    private BaseballGame baseballGame;

    public BaseballGameService() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }
    public void startGame() {
        outputView.printGameStartMessage();
        boolean continueGame = true;
        while (continueGame) {
            playSingleGame();
            continueGame = askContinue();
        }
    }

    private void playSingleGame() {
        initializeGame();
        playUntilGameFinished();
        outputView.printGameFinishedMessage();
    }

    private void playUntilGameFinished() {
        boolean gameFinished = false;
        while (!gameFinished) {
            gameFinished = playOneRound();
        }
    }

    private boolean playOneRound() {
        outputView.printInputNumberMessage();
        BaseballNumbers userGuess = new BaseballNumbers(inputView.readNumber());
        Hint hint = baseballGame.guess(userGuess);
        outputView.printHint(hint);
        return hint.isGameFinished();
    }

    private void initializeGame() {
        baseballGame = new BaseballGame();
    }

    private boolean askContinue() {
        outputView.printAskContinueMessage();
        int userInput = InputView.readContinue();
        return userInput == CONTINUE_GAME;
    }
}
