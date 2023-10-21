package baseball.controller;

public class InputValidator {
    
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;

    public Boolean isTreeLengthLetter(String playerInput) {
        return playerInput.length() == BASEBALL_GAME_NUMBER_LENGTH;
    }
}
