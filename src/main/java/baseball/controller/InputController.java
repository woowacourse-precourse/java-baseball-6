package baseball.controller;

import baseball.model.Player;

public class InputController {
    public static Player generatePlayerTripleBalls(String inputFromInputView) {
        try {
            return new Player(inputFromInputView);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
