package model;

import static validation.Validation.inputValidationCheck;

public class PlayerInput {
    private String playerInput;

    public PlayerInput(String playerInput) {
        checkPlayerInput(playerInput);
        this.playerInput = playerInput;
    }

    public String getPlayerInput() {
        return playerInput;
    }

    public void checkPlayerInput(String playerInput) {
        inputValidationCheck(playerInput);
    }
}
