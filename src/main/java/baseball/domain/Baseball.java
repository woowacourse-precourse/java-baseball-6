package baseball.domain;

import baseball.exception.ErrorMessage;
import baseball.exception.InvalidInputException;

import java.util.List;

public class Baseball {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBERS_COUNT = 3;

    private Baseball() {
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateNumberLength(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
    }

    private static void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < MIN_NUMBER
                || number > MAX_NUMBER)) {
            throw new InvalidInputException(ErrorMessage.INVALID_RANGE);
        }
    }

    private static void validateDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBERS_COUNT) {
            throw new InvalidInputException(ErrorMessage.DUPLICATED_NUMBERS);
        }
    }

    private static void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new InvalidInputException(ErrorMessage.INVALID_LENGTH);
        }
    }

}
