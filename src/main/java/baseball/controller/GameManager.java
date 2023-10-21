package baseball.controller;

import baseball.domain.BallNumber;
import baseball.domain.Result;
import baseball.system.SystemConstant;
import baseball.verifier.InputVerifier;
import baseball.view.InputHandler;
import baseball.view.OutputHandler;

public class GameManager {
    BallNumber computerNumber;

    GameManager() {
        computerNumber = RandomNumberGenerator.generate();
    }

    void playRound() {
        BallNumber playerNumber = returnPlayerNumber();
        ResultCalculator resultCalculator = new ResultCalculator(computerNumber);
        Result roundResult = resultCalculator.calculateResult(playerNumber);
        if (roundResult.isStrikesAllOfBalls()) {
            choiceNewGameOrGameOver();
            return;
        }
        showResultWhilePlayingRound(roundResult);
        playRound();
    }

    private void showResultWhilePlayingRound(Result toShow) {
        if (toShow.isNothing()) {
            OutputHandler.printNothing();
            return;
        }
        OutputHandler.printStrikesAndBalls(toShow.numberOfStrikes, toShow.numberOfBalls);
    }

    private BallNumber returnPlayerNumber() {
        String playerNumber = InputHandler.insertBallNum();
        InputVerifier.checkBallNumber(playerNumber);
        return new BallNumber(playerNumber);
    }

    private void choiceNewGameOrGameOver() {
        OutputHandler.printAllStrike();
        String playerChoice = InputHandler.insertNewGameOrGameOver();
        InputVerifier.checkGameNumber(playerChoice);
        if (Integer.parseInt(playerChoice) == SystemConstant.NEW_GAME) {
            SystemManager.newGame();
        }
    }
}
