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
        OutputHandler.printStrikesAndBalls(toShow);
    }

    private BallNumber returnPlayerNumber() {
        InputHandler inputHandler = new InputHandler();
        InputVerifier inputVerifier = new InputVerifier();
        String playerNumber = inputHandler.insertBallNum();
        inputVerifier.checkBallNumber(playerNumber);
        return new BallNumber(playerNumber);
    }

    private void choiceNewGameOrGameOver() {
        OutputHandler.printAllStrike();
        InputHandler inputHandler = new InputHandler();
        InputVerifier inputVerifier = new InputVerifier();
        String playerChoice = inputHandler.insertNewGameOrGameOver();
        inputVerifier.checkGameNumber(playerChoice);
        int intChoice = Integer.parseInt(playerChoice);
        if (intChoice == SystemConstant.NEW_GAME) {
            SystemManager.newGame();
        }
    }

}
