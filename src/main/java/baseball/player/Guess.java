package baseball.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Guess {
    private static final char MIN_ALLOWABLE_DIGIT = '1';
    private static final char MAX_ALLOWABLE_DIGIT = '9';
    private static final int VALID_NUMBER_LENGTH = 3;

    private final List<Character> playerGuess;

    public Guess(String playerInput) {
        checkNullInput(playerInput);
        List<Character> playerInputAsChars = strToCharacterList(playerInput);
        checkInvalidLength(playerInputAsChars);
        checkInvalidInput(playerInputAsChars);
        checkDuplicateDigit(playerInputAsChars);
        this.playerGuess = playerInputAsChars;
    }

    private void checkNullInput(String playerInput) {
        if (playerInput == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInvalidLength(List<Character> playerInputAsChars) {
        if (playerInputAsChars.size() != VALID_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInvalidInput(List<Character> playerInputAsChars) {
        for (char digit : playerInputAsChars) {
            checkInvalidDigit(digit);
        }
    }

    private void checkInvalidDigit(char digit) {
        if (digit < MIN_ALLOWABLE_DIGIT || digit > MAX_ALLOWABLE_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateDigit(List<Character> playerInputAsChars) {
        Set<Character> playerInputAsSet = new HashSet<>(playerInputAsChars);
        if (playerInputAsChars.size() != playerInputAsSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Character> strToCharacterList(String string) {
        List<Character> characterList = new ArrayList<>();
        for (char character : string.toCharArray()) {
            characterList.add(character);
        }
        return characterList;
    }

    public List<Character> getPlayerGuessAsChars() {
        return playerGuess;
    }
}
