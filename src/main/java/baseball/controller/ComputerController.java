package baseball.controller;

import baseball.model.GameNumber;

public class ComputerController {
    GameNumber gameNumber = new GameNumber();

    public void startGame() {
        gameNumber.setRandomNumbers();
    }
}
