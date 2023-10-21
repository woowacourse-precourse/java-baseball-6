package baseball.domain.number.validation;

import static baseball.domain.number.NumberConstants.MAX_NUMBER;
import static baseball.domain.number.NumberConstants.MIN_NUMBER;

import java.util.List;

public class DigitRangeValidator {

    private static final String INVALID_RANGE_NUMBER = "각 자릿수는 1 ~ 9여야 합니다.";

    public static void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > MAX_NUMBER || number < MIN_NUMBER) {
                throw new IllegalArgumentException(INVALID_RANGE_NUMBER);
            }
        }
    }
}
