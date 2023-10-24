package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    private static final int START_INCLUSIVE = Constants.START_INCLUSIVE;
    private static final int END_INCLUSIVE = Constants.END_INCLUSIVE;
    private static final int ANSWER_DIGIT = Constants.ANSWER_DIGIT;
    private static final String START = Constants.START;
    private static final String QUIT = Constants.QUIT;

    public void validateNumberInput(String input) {
        validateLengthOfDigits(input);
        validateFormatOfDigits(input);
        validateNoDuplicateDigits(input);
    }

    private void validateLengthOfDigits(String input) {
        if (input.length() != ANSWER_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateFormatOfDigits(String input) {
        for (char digit : input.toCharArray()) {
            if (!Character.isDigit(digit) || digit < '0' + START_INCLUSIVE || digit > '0' + END_INCLUSIVE) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNoDuplicateDigits(String input) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : input.toCharArray()) {
            if (!uniqueDigits.add(digit)) {
                throw new IllegalArgumentException();
            }
        }

    }

    public void validateGameStatusInput(String gameStatusInput) {
        if (!gameStatusInput.equals(START) && !gameStatusInput.equals(QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
