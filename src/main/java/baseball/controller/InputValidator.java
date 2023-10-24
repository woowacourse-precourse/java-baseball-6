package baseball.controller;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    private static final int BASEBALL_GAME_NUMBER_LENGTH = BaseBallConstants.BASEBALL_GAME_NUMBER_LENGTH;
    private static final int MIN_DIGIT = BaseBallConstants.MIN_DIGIT;
    private static final int MAX_DIGIT = BaseBallConstants.MAX_DIGIT;
    private static final String WRONG_LENGTH_THROW_MESSAGE = BaseBallConstants.WRONG_LENGTH_THROW_MESSAGE;
    private static final String WRONG_RANGE_THROW_MESSAGE = BaseBallConstants.WRONG_RANGE_THROW_MESSAGE;
    private static final String DUPLICATE_INPUT_MESSAGE = BaseBallConstants.DUPLICATE_INPUT_MESSAGE;
    private static final String CONTINUE_NUMBER = BaseBallConstants.CONTINUE_NUMBER;
    private static final String GAME_TERMINATE_NUMBER = BaseBallConstants.GAME_TERMINATE_NUMBER;
    private static final String WRONG_INPUT_GAME_CONTINUE_CHOICE_MESSAGE = BaseBallConstants.WRONG_INPUT_GAME_CONTINUE_CHOICE_MESSAGE;


    public boolean isThreeLengthLetter(String playerInput) {
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
                return true;
            }
            seenChar.add(playerInput.charAt(i));
        }
        return false;
    }

    public boolean isValidNumber(String playerInput) {
        playerInput = playerInput.replaceAll(" ", "");
        if (!isThreeLengthLetter(playerInput)) {
            throw new IllegalArgumentException(WRONG_LENGTH_THROW_MESSAGE);
        } else if (!isAllDigit(playerInput)) {
            throw new IllegalArgumentException(WRONG_RANGE_THROW_MESSAGE);
        } else if (hasDuplicateChars(playerInput)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
        }
        return true;
    }

    public boolean isValidContinueGameChoice(String playerInput) {
        playerInput = playerInput.replaceAll(" ", "");
        if (playerInput.equals(CONTINUE_NUMBER) || playerInput.equals(GAME_TERMINATE_NUMBER)) {
            return true;
        }
        throw new IllegalArgumentException(WRONG_INPUT_GAME_CONTINUE_CHOICE_MESSAGE);
    }

}
