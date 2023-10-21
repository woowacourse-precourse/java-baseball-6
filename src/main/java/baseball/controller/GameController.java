package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private GameController() {}

    public static void startGame() {
        OutputView.printStartMessage();
    }
}
