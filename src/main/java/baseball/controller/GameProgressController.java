package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameProgressController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void progressGame() {
        outputView.printGameStart();
        String userInputString = inputView.getUserGuessingNumbers();
    }
}
