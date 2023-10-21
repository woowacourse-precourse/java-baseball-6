package baseball.domain.number.validation;

import static baseball.domain.number.NumberConstants.MAX_NUMBER;
import static baseball.domain.number.NumberConstants.MIN_NUMBER;

import baseball.domain.number.NumberConstants;
import java.util.Collections;
import java.util.List;

public class GameNumbersValidation {

    private static final String WRONG_LENGTH = "숫자는 3자릿수여야 합니다.";
    private static final String DUPLICATE_NUMBER = "중복된 숫자가 입력되었습니다.";
    private static final String INVALID_RANGE_NUMBER = "각 자릿수는 1 ~ 9여야 합니다.";

    public static void validate(List<Integer> numbers) {
        validateLength(numbers);
        checkDuplicateNumbers(numbers);
        validateDigitRange(numbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != NumberConstants.NUMBERS_LENGTH) {
            throw new IllegalArgumentException(WRONG_LENGTH);
        }
    }

    private static void checkDuplicateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER);
            }
        }
    }

    private static void validateDigitRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > MAX_NUMBER || number < MIN_NUMBER) {
                throw new IllegalArgumentException(INVALID_RANGE_NUMBER);
            }
        }
    }
}
