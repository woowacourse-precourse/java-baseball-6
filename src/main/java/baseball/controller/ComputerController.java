package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class ComputerController {
    GameNumber gameNumber = new GameNumber();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void startGame() {
        outputView.printStartGame();
        gameNumber.setRandomNumbers();
        inputView.enterGameNumber();
    }
}
