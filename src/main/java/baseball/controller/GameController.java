package baseball.controller;

import baseball.model.Game;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private Game game;

    public GameController() {
        OutputView.printGameStart();
    }

    public void run() {
        this.game = new Game();
    }

    public void playGame() {
        String inputNumber = InputView.getInputNumber();
    }
}
