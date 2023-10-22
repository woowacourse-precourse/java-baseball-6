package controller;

import domain.ComputerNumber;
import view.GameView;
import service.GameService;

public class BaseballController {

    public void gameStart() {
        GameView.printGameStartMessage();
        ComputerNumber computerNumber = new ComputerNumber();
    }

}
