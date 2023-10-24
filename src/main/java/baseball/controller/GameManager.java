package baseball.controller;

import baseball.domain.BallNumber;
import baseball.domain.GameScore;
import baseball.system.SystemConstant;
import baseball.verifier.InputVerifier;
import baseball.view.InputHandler;
import baseball.view.OutputHandler;

public class GameManager {
    private final BallNumber computerNumber;

    GameManager() {
        computerNumber = new BallNumber(RandomNumberGenerator.generate());
    }

    void playRound() {
        BallNumber playerNumber = inputPlayerNumber();
        ResultCalculator resultCalculator = new ResultCalculator(computerNumber);
        endRound(resultCalculator.calculateResult(playerNumber));
    }

    private void endRound(GameScore roundGameScore) {
        if (roundGameScore.isStrikesAllOfBalls()) {
            choiceNewGameOrGameOver();
            return;
        }
        showResultWhilePlayingRound(roundGameScore);
        playRound();
    }

    private void showResultWhilePlayingRound(GameScore toShow) {
        if (toShow.isNothing()) {
            OutputHandler.printNothing();
            return;
        }
        OutputHandler.printStrikesAndBalls(toShow.numberOfStrikes, toShow.numberOfBalls);
    }

    private BallNumber inputPlayerNumber() {
        String playerNumber = InputHandler.inputBallNum();
        InputVerifier.checkBallNumber(playerNumber);
        return new BallNumber(playerNumber);
    }

    private void choiceNewGameOrGameOver() {
        OutputHandler.printAllStrike();
        String playerChoice = InputHandler.inputNewGameOrGameOver();
        InputVerifier.checkGameNumber(playerChoice);
        if (playerChoice.equals(SystemConstant.NEW_GAME)) {
            SystemManager.newGame();
        }
    }
}
