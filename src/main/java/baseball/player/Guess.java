package baseball.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Guess {
    private static final char ZERO_TO_UNICODE = '0';
    private static final char MIN_ALLOWABLE_DIGIT = 1;
    private static final char MAX_ALLOWABLE_DIGIT = 9;
    private static final int VALID_NUMBER_LENGTH = 3;

    private final List<Integer> guess;

    public Guess(String playerInput) {
        checkNullInput(playerInput);
        List<Integer> playerInputList = strToIntegerList(playerInput);
        checkInvalidLength(playerInputList);
        checkInvalidInput(playerInputList);
        checkDuplicateDigit(playerInputList);
        guess = playerInputList;
    }

    private void checkNullInput(String playerInput) {
        if (playerInput == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInvalidLength(List<Integer> playerInputList) {
        if (playerInputList.size() != VALID_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInvalidInput(List<Integer> playerInputList) {
        for (int digit : playerInputList) {
            checkInvalidDigit(digit);
        }
    }

    private void checkInvalidDigit(int digit) {
        if (digit < MIN_ALLOWABLE_DIGIT || digit > MAX_ALLOWABLE_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateDigit(List<Integer> playerInputList) {
        Set<Integer> playerInputSet = new HashSet<>(playerInputList);
        if (playerInputList.size() != playerInputSet.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> strToIntegerList(String string) {
        List<Integer> integerList = new ArrayList<>();
        for (char character : string.toCharArray()) {
            integerList.add(charToInteger(character));
        }
        return integerList;
    }

    private int charToInteger(char character) {
        return character - ZERO_TO_UNICODE;
    }

    public List<Integer> getGuessAsList() {
        return guess;
    }
}
