package baseball.Controller;

import baseball.Model.BaseballGame;
import baseball.View.InputView;
import baseball.View.OutputView;

public class BaseballGameController {
    public void startBaseballGame() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.displayGameStartMessage();
        boolean continueBaseballGame = true;

        while (continueBaseballGame) {
            playBaseballGame(inputView, outputView);
            continueBaseballGame = inputView.readRestartNumber();
        }

        outputView.displayGameExitMessage();
    }

    private void playBaseballGame(InputView inputView, OutputView outputView) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.initializeGame();
        boolean isGameWon = baseballGame.play(inputView, outputView);
        outputView.displayGameEndMessage(isGameWon);
    }
}

