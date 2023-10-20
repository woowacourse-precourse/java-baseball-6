package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.InputConstant.*;
import static baseball.exception.ExceptionMessage.*;

public class InputValidator {

    public int validEndNumber(String input) {
        validateIncludeChar(input);
        validateInvalidLength(input, VALID_END_INPUT_LENGTH.getNum());
        int endNum = validateNumberRange(input);

        return endNum;
    }

    public List<Integer> validateInputNumbers(String input) {
        validateInvalidLength(input, VALID_NUMBERS_LENGTH.getNum());
        validateIncludeChar(input);
        List<Integer> inputNumbers = validateNumber(input);

        return inputNumbers;
    }

    private void validateIncludeChar(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(INVALID_INPUT_CHAR_ERROR.getErrorMsg());
        }
    }

    private void validateInvalidLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH_ERROR.getErrorMsg());
        }
    }

    private List<Integer> validateNumber(String input) {
        List<Integer> inputNumbers = input.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());

        validateNumberRange(inputNumbers);
        validateDuplicateNumber(inputNumbers);

        return inputNumbers;
    }

    private void validateNumberRange(List<Integer> inputNumbers) {
        long count = inputNumbers.stream()
                .filter(num -> num >= 1 && num <= 9)
                .count();

        if (count != inputNumbers.size()) {
            throw new IllegalArgumentException(INVALID_RANGE_OUT_NUMBER_ERROR.getErrorMsg());
        }
    }

    private int validateNumberRange(String input) {
        int endNum = Integer.valueOf(input);
        if (endNum != NEW_GAME.getNum() && endNum != END_GAME.getNum()) {
            throw new IllegalArgumentException(INVALID_END_INPUT_NUMBER_ERROR.getErrorMsg());
        }

        return endNum;
    }

    private void validateDuplicateNumber(List<Integer> inputNumbers) {
        long count = inputNumbers.stream().distinct().count();

        if (count != inputNumbers.size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER_ERROR.getErrorMsg());
        }
    }
}
