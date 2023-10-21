package baseball.controller;

import java.util.HashSet;
import java.util.Set;

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

    public boolean hasDuplicateChars(String playerInput) {
        Set<Character> seenChar = new HashSet<>();
        for (int i = 0; i < playerInput.length(); i++) {
            if (seenChar.contains(playerInput.charAt(i))) {
                return false;
            }
            seenChar.add(playerInput.charAt(i));
        }
        return true;
    }
}
