package baseball.Controller;

import baseball.Model.BaseballGame;
import baseball.View.InputView;
import baseball.View.OutputView;

public class BaseballGameController {
    public void startBaseballGame() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BaseballGame baseballGame = new BaseballGame();

        outputView.displayGameStartMessage();
        boolean continueGame = true;

        while (continueGame) {
            baseballGame.initializeGame();
            boolean isGameWon = baseballGame.play(inputView, outputView);
            outputView.displayGameEndMessage(isGameWon);

            continueGame = inputView.readRestartNumber();
        }

        outputView.displayGameExitMessage();
    }
}
