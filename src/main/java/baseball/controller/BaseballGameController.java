package baseball.controller;

import baseball.View.InputView;
import baseball.View.OutputView;

public class BaseballGameController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void game() {
        outputView.printInit();
        inputView.inputUserGuess();
        ///
    }


}
