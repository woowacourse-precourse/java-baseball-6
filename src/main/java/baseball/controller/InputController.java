package baseball.controller;

import baseball.model.Player;

public class InputController {
    public static Player generatePlayerTripleBalls(String inputFromInputView) {
        return new Player(inputFromInputView);
    }
}
