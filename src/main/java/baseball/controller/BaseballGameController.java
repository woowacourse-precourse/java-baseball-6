package baseball.controller;

import baseball.model.Constants;
import baseball.model.Validation;
import baseball.view.InputView;

public class BaseballGameController {

    public boolean isRestart() {
        String restartOrEndNumber = InputView.inputNumbers();
        Validation.validateRestartOrEnd(restartOrEndNumber);

        return Constants.GAME_RESTART_NUMBER.equals(restartOrEndNumber);
    }
}
