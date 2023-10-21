package controller;

import model.system.GameController;

public class NumberBaseBallController {

    public NumberBaseBallController() {
    }

    public void run() {
        GameController gameController = new GameController();
        gameController.execute();
    }
}
