package baseball.controller;

import baseball.View.InputView;
import baseball.View.OutputView;
import baseball.domain.BallCount;
import baseball.domain.Opponent;

public class BaseballGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void game() {
        Opponent opponent = initOpponent();
        if (userInteraction(opponent)) {
            game();
        }
    }

    private Opponent initOpponent() {
        outputView.printInit();

        return new Opponent();
    }

    private boolean promptRestart() {
        outputView.printGameOver();
        String userInput = inputView.inputQuitOrRestart();
        return userInput.equals("1");
    }

    private boolean userInteraction(Opponent opponent) {
        String userInput = inputView.inputUserGuess();
        BallCount ballCount = opponent.analyzeTry(userInput);
        outputView.printResult(ballCount.comment());
        if (ballCount.gameEnd()) {
            return promptRestart();
        }
        return userInteraction(opponent);
    }
}
