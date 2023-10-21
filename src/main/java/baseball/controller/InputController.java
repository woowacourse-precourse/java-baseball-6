package baseball.controller;

import baseball.validate.GameValidate;
import baseball.validate.InputValidate;
import baseball.view.InputView;

public class InputController {
    private final InputView inputView;
    private final InputValidate inputValidate;
    private final GameValidate gameValidate;

    public InputController() {
        this.inputView = new InputView();
        this.inputValidate = new InputValidate();
        this.gameValidate = new GameValidate();
    }

    public boolean isRestartGame() {
        String input  = inputView.getPlayerRestart();
        int restartNumber = inputValidate.checkNumber(input);
        gameValidate.checkGameRestartInput(restartNumber);
        return restartNumber == 1;
    }

    public String getPlayerGuessNumber() {
        String input = inputView.getPlayerGuessNumbers();
        inputValidate.checkNumbers(input);
        return input;
    }
}
