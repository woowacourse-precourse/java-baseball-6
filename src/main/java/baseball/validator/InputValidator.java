package baseball.validator;

import baseball.constants.ValidatorConstants;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public void checkBaseballNumber(String input) {
        if (input == null || input.length() != ValidatorConstants.VALID_INPUT_LENGTH) {
            throw new IllegalArgumentException(ValidatorConstants.LENGTH_ERROR_MESSAGE);
        }

        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                throw new IllegalArgumentException(ValidatorConstants.RANGE_ERROR_MESSAGE);
            }
        }

        if (hasDuplicateNumbers(input)) {
            throw new IllegalArgumentException(ValidatorConstants.DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void checkRestartInput(String input) {
        if (!("1".equals(input) || "2".equals(input))) {
            throw new IllegalArgumentException(ValidatorConstants.RESTART_INPUT_ERROR_MESSAGE);
        }
    }

    private boolean hasDuplicateNumbers(String input) {
        Set<Character> numberSet = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!numberSet.add(ch)) {
                return true;
            }
        }
        return false;
    }

}
