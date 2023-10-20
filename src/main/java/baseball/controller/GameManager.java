package baseball.controller;

import baseball.domain.BallNumber;
import baseball.domain.Result;
import baseball.verifier.InputVerifier;
import baseball.view.InputHandler;

public class GameManager {
    BallNumber computerNumber;

    GameManager() {
        computerNumber = RandomNumberGenerator.generate();
    }

    private void playRound() {
        BallNumber playerNumber = returnPlayerNumber();
        ResultCalculator resultCalculator = new ResultCalculator(computerNumber);
        Result roundResult = resultCalculator.calculateResult(playerNumber);
    }

    private BallNumber returnPlayerNumber() {
        InputHandler inputHandler = new InputHandler();
        InputVerifier inputVerifier = new InputVerifier();
        String playerNumber = inputHandler.insertBallNum();
        inputVerifier.checkBallNumber(playerNumber);
        return new BallNumber(Integer.parseInt(playerNumber));
    }

}
