package controller;

import entity.NumberBaseball;
import view.InputView;
import view.OutputView;

public class BaseballController {

    public void startBaseball() {
        OutputView.printGameStartView();
    }

    public void getUserNumber() {
        String userInput = InputView.getUserInput();
        NumberBaseball userNumberBaseball = new NumberBaseball(userInput);
        userNumberBaseball.isValid();
    }
}
