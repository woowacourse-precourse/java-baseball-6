package baseball.controller;

import baseball.model.Player;
import baseball.util.Constants;
import baseball.util.Util;

import static baseball.util.Util.hasSameInput;

public class InputController {
    public static Player generatePlayerTripleBalls(String inputFromInputView) {
        return new Player(inputFromInputView);
    }

    public static void hasWrongInput(String inputGameRestart) {
        if (hasSameInput(inputGameRestart, Constants.GAME_RESTART_NUMBER)
                && hasSameInput(inputGameRestart, Constants.GAME_END_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
