package baseball.baseballV1.controller;

import baseball.baseballV1.model.Player;
import baseball.baseballV1.util.Constants;
import baseball.baseballV1.util.Util;

public class InputController {
    public static Player generatePlayerTripleBalls(String inputFromInputView) {
        return new Player(inputFromInputView);
    }

    public static void hasWrongInput(String inputGameRestart) {
        if (Util.hasSameInput(inputGameRestart, Constants.GAME_RESTART_NUMBER)
                && Util.hasSameInput(inputGameRestart, Constants.GAME_END_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
