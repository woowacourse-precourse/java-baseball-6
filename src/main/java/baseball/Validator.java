package baseball;

import java.util.List;

public class Validator {
    private static final Integer CORRECT_LENGTH = 3;
    private static final String RESTART_NUMBER = "1";
    private static final String EXIT_NUMBER = "2";
    private static final String ZERO = "0";
    private static final String VALID_NUMBER_REGEX = "^[0-9]*$";

    public void validateNumberInput(String input) {
        if (isEmptyValue(input)) {
            throw BaseballException.of(ErrorMessage.EMPTY_VALUE);
        }
        if (!isCorrectLength(input)) {
            throw BaseballException.of(ErrorMessage.INVALID_LENGTH);
        }
        if (!isNumberType(input)) {
            throw BaseballException.of(ErrorMessage.NONE_NUMERIC);
        }
        if (isContainingZero(input)) {
            throw BaseballException.of(ErrorMessage.CONTAINS_ZERO);
        }
    }

    public void validateRestartInput(String input) {
        if (isNotOneOrTwo(input)) {
            throw BaseballException.of(ErrorMessage.NOT_REQUIRED_RESTART_INPUT);
        }
    }

    public void validateDuplicatedNumber(List<Character> numbers, char number) {
        if (isDuplicated(numbers, number)) {
            throw BaseballException.of(ErrorMessage.IS_DUPLICATED_VALUE);
        }
    }

    private boolean isDuplicated(List<Character> numbers, char number) {
        return numbers.contains(number);
    }

    public boolean isNotOneOrTwo(String input) {
        return !input.equals(RESTART_NUMBER) && !input.equals(EXIT_NUMBER);
    }

    private boolean isContainingZero(String input) {
        return input.contains(ZERO);
    }

    private boolean isCorrectLength(String input) {
        return input.length() == CORRECT_LENGTH;
    }

    private boolean isEmptyValue(String input) {
        return input.isBlank();
    }

    private boolean isNumberType(String input) {
        return input.matches(VALID_NUMBER_REGEX);
    }
}
