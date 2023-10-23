package controller;

import domain.ComputerNumber;
import domain.PlayerNumber;
import view.GameView;

public class BaseballController {
    ComputerNumber computerNumber = new ComputerNumber();
    PlayerNumber playerNumber = new PlayerNumber();

    public void gameStart() {
        GameView.printGameStartMessage();
        computerNumber.createComputerNumbers();
        round();
        GameView.printWinMessage();

    }

    private void round() {
        do {
            PlayerNumber.inputPlayerNumber();
            GameView.printResult(computerNumber.countAndGetResult(playerNumber));
        } while(!playerNumber.isWin);
    }

}
