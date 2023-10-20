package baseball.controller;

import baseball.util.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    public void startBaseballGame() {
        printGameStartMessage();
        getUserNumber();
    }

    private void printGameStartMessage() {
        OutputView outputView = new OutputView();
        outputView.printGameStartMessage();
    }

    private void getUserNumber() {
        InputView inputView = new InputView();
        String userNumber = inputView.getUserNumber();
        checkUserNumberValidate(userNumber);
    }

    private void checkUserNumberValidate(String userInputNumber) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkInputValidation(userInputNumber);
    }
}
