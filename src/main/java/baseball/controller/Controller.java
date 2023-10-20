package baseball.controller;

import baseball.view.InputView;

public class Controller {

    private final InputView inputView = new InputView();

    public void run() {
        String inputtedNumbers = inputView.inputNumbers();
    }
}
