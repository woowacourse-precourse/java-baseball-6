package baseball.controller;

import baseball.view.OutputView;

public class GameController {
        OutputView output = new OutputView();
    public void run() {
        output.printStartMessage();
    }
}
