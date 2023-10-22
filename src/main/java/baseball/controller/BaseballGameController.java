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

        while(true) {
            String userInput = inputView.inputUserGuess();
            BallCount ballCount = opponent.analyzeTry(userInput);
            outputView.printResult(ballCount.comment());
            if(ballCount.gameEnd()) {
                outputView.printGameOver();
                String quitOrRestart = inputView.inputQuitOrRestart();
                if(quitOrRestart.equals("1")) {
                    game();
                }
                break;
            }
        }
    }

    private Opponent initOpponent() {
        outputView.printInit();

        return new Opponent();
    }
}
