package baseball.controller;

import baseball.model.Player;
import baseball.util.Constants;

public class InputController {
    public static Player generatePlayerTripleBalls(String inputFromInputView) {
        return new Player(inputFromInputView);
    }

    public static void hasWrongInput(String inputGameRestart) {
        if (!inputGameRestart.equals(Constants.GAME_RESTART_NUMBER)
                && !inputGameRestart.equals(Constants.GAME_END_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }
}
