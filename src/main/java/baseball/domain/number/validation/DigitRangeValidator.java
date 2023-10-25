package baseball.domain.number.validation;

import baseball.domain.number.NumberConstants;
import java.util.List;

public class DigitRangeValidator {

    private static final String INVALID_RANGE_NUMBER = "각 자릿수는 1 ~ 9여야 합니다.";

    public static void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > NumberConstants.MAX_NUMBER || number < NumberConstants.MIN_NUMBER) {
                throw new IllegalArgumentException(INVALID_RANGE_NUMBER);
            }
        }
    }
}
