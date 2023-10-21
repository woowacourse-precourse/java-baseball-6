package baseball.controller;

import baseball.view.OutputView;

public class GameController {
    OutputView outputView = new OutputView();
    ComputerController computerController = new ComputerController();

    public void gameStart() {
        outputView.printStartGame();
        computerController.startGame();
    }
}
