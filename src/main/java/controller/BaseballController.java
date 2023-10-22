package controller;

import view.GameView;
import service.GameService;

public class BaseballController {

    public void gameStart() {
        GameView.printGameStartMessage();
        GameService.gameStart();
    }

}
