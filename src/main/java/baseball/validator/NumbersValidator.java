package baseball.validator;

import baseball.exception.ErrorMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersValidator {

    public static void validateNumbersSize(int validSize, List<Integer> numbers) {
        if (numbers.size() != validSize) {
            throw new IllegalArgumentException(String.format(ErrorMessages.INVALID_SIZE_ERROR, validSize));
        }
    }

    public static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATE_NUMBERS_ERROR);
        }
    }

    public static void validateContainsZero(List<Integer> numbers) {
        if (numbers.contains(0)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_ERROR);
        }
    }
}
