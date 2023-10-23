package baseball.controller;

import java.util.ArrayList;

public class PlayerInputController {

    private static final int PLAYER_INPUT_LENGTH = 3;

    private final Validator validator;

    public PlayerInputController(Validator validator) {
        this.validator = validator;
    }

    public ArrayList<Integer> handlePlayerInput(String playerFirstInput) {
        validator.validatePlayerInput(playerFirstInput);
        String[] numbers = playerFirstInput.replace(" ", "").split("");
        ArrayList<Integer> playerInput = new ArrayList<>();
        for (int i = 0; i < PLAYER_INPUT_LENGTH; i++) {
            playerInput.add(Integer.valueOf(numbers[i]));
        }
        return playerInput;
    }
}
