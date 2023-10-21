package baseball.controller;

public class InputValidator {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final char MIN_DIGIT = '1';
    private static final char MAX_DIGIT = '9';

    public boolean isTreeLengthLetter(String playerInput) {
        return playerInput.length() == BASEBALL_GAME_NUMBER_LENGTH;
    }

    public boolean isAllDigit(String playerInput) {
        for (int i = 0; i < playerInput.length(); i++) {
            if (playerInput.charAt(i) < MIN_DIGIT || playerInput.charAt(i) > MAX_DIGIT) {
                return false;
            }
        }
        return true;
    }
}
