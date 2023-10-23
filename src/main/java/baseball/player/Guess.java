package baseball.player;

import java.util.HashSet;
import java.util.Set;

public class Guess {
    private static final char MIN_ALLOWABLE_DIGIT = '1';
    private static final char MAX_ALLOWABLE_DIGIT = '9';
    private static final int VALID_NUMBER_LENGTH = 3;

    private final String playerGuess;

    public Guess(String playerInput) {
        validateInput(playerInput);
        this.playerGuess = playerInput;
    }

    private void validateInput(String playerInput) {
        checkNullInput(playerInput);
        checkInvalidLength(playerInput);
        checkInvalidInput(playerInput);
        checkDuplicateInput(playerInput);
    }

    private void checkNullInput(String playerInput) {
        if (playerInput == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInvalidLength(String playerInput) {
        if (playerInput.length() != VALID_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInvalidInput(String playerInput) {
        for (char digit : toCharArray(playerInput)) {
            checkInvalidDigit(digit);
        }
    }

    private void checkDuplicateInput(String playerInput) {
        Set<Character> playerInputAsSet = new HashSet<>();
        for (char digit : toCharArray(playerInput)) {
            playerInputAsSet.add(digit);
        }
        compareLength(playerInput, playerInputAsSet);
    }

    private void checkInvalidDigit(char digit) {
        if (digit < MIN_ALLOWABLE_DIGIT || digit > MAX_ALLOWABLE_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private char[] toCharArray(String string) {
        return string.toCharArray();
    }

    private void compareLength(String playerInput, Set<Character> playerInputAsSet) {
        if (playerInput.length() != playerInputAsSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return playerGuess;
    }
}
