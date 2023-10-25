package baseball.util;

import baseball.controller.BaseBallConstants;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public boolean isValidNumbers(String playerInput) {
        if (!isThreeLengthLetter(playerInput)) {
            throw new IllegalArgumentException(BaseBallConstants.WRONG_LENGTH_THROW_MESSAGE);
        } else if (!isAllDigit(playerInput)) {
            throw new IllegalArgumentException(BaseBallConstants.WRONG_RANGE_THROW_MESSAGE);
        } else if (hasDuplicateChars(playerInput)) {
            throw new IllegalArgumentException(BaseBallConstants.DUPLICATE_INPUT_MESSAGE);
        }
        return true;
    }

    public boolean isValidContinueGameChoice(String playerInput) {
        if (playerInput.equals(BaseBallConstants.SIGNAL_CONTINUE) || playerInput.equals(
                BaseBallConstants.SIGNAL_TERMINATE)) {
            return true;
        }
        throw new IllegalArgumentException(BaseBallConstants.WRONG_INPUT_GAME_CONTINUE_CHOICE_MESSAGE);
    }

    public boolean isThreeLengthLetter(String playerInput) {
        return playerInput.length() == BaseBallConstants.BASEBALL_GAME_NUMBER_LENGTH;
    }

    public boolean isAllDigit(String playerInput) {
        for (int i = 0; i < playerInput.length(); i++) {
            if (playerInput.charAt(i) < BaseBallConstants.MIN_DIGIT
                    || playerInput.charAt(i) > BaseBallConstants.MAX_DIGIT) {
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
}
