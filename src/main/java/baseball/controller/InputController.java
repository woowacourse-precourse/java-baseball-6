package baseball.controller;

import baseball.validate.GameValidate;
import baseball.validate.InputValidate;
import baseball.view.InputView;
import java.util.List;

public class InputController {
    private final InputView inputView;
    private final InputValidate inputValidate;
    private final GameValidate gameValidate;

    public InputController() {
        this.inputView = new InputView();
        this.inputValidate = new InputValidate();
        this.gameValidate = new GameValidate();
    }

    public Integer getPlayerRestart() {
        String input = inputView.getPlayerRestart();
        Integer restartNumber = inputValidate.checkNumber(input);
        gameValidate.checkGameRestartInput(restartNumber);
        return restartNumber;
    }

    public List<Integer> getPlayerGuessNumber() {
        String input = inputView.getPlayerGuessNumbers();
        List<Integer> playerInputNumbers = inputValidate.checkNumbers(input);
        gameValidate.checkPlayerGuessNumbers(playerInputNumbers);
        return playerInputNumbers;
    }
}
