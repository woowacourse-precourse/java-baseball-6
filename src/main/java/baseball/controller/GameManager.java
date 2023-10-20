package baseball.controller;

import baseball.domain.BallNumber;
import baseball.view.InputHandler;

public class GameManager {
    BallNumber computerNumber;

    GameManager() {
        computerNumber = RandomNumberGenerator.generate();
    }
    private void playRound() {
        InputHandler inputHandler = new InputHandler();
        BallNumber playerNumber = new BallNumber(inputHandler.insertIntNum());

    }

}
