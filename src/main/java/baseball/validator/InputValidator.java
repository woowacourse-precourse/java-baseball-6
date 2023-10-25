package baseball.validator;

import baseball.config.GameConfig;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public boolean isValidInput(String userInput) {
        return hasValidLength(userInput) &&
                hasOnlyDigits(userInput) &&
                isWithinRange(userInput) &&
                hasUniqueDigits(userInput);
    }

    private boolean hasValidLength(String userInput) {
        return userInput.length() == GameConfig.DIGIT_COUNT.getValue();
    }

    private boolean hasOnlyDigits(String userInput) {
        for (char ch : userInput.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWithinRange(String userInput) {
        for (char ch : userInput.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            if (digit < GameConfig.START_OF_RANGE.getValue() || digit > GameConfig.END_OF_RANGE.getValue()) {
                return false;
            }
        }
        return true;
    }

    private boolean hasUniqueDigits(String userInput) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char ch : userInput.toCharArray()) {
            if (uniqueDigits.contains(ch)) {
                return false;
            }
            uniqueDigits.add(ch);
        }
        return true;
    }

    public boolean isReplayOrStopInputValid(String userInput) {
        return userInput.equals(String.valueOf(GameConfig.REPLAY.getValue()))
                || userInput.equals(String.valueOf(GameConfig.STOP.getValue()));
    }
}
