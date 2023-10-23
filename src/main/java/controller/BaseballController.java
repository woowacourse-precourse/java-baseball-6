package controller;

import domain.ComputerNumber;
import domain.PlayerNumber;
import view.GameView;

public class BaseballController {

    public void gameStart() {
        GameView.printGameStartMessage();
        ComputerNumber computerNumber = new ComputerNumber();
        oneRound();
    }

    private void oneRound() {
        PlayerNumber.inputPlayerNumber();
    }

}
