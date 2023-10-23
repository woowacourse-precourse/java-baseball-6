package baseball.controller;

import baseball.view.UserInputView;

public class GameController {

    private final UserInputView userInputView;
    private final ValidationController validationController;

    public GameController() {
        this.userInputView = new UserInputView();
        this.validationController = new ValidationController();
    }

    public void startGame() {
        String userInput = userInputView.requestNumberInput();
        validationController.validateInput(userInput);
    }
}
