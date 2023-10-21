package baseball.domain.number.validation;

import baseball.domain.number.NumberConstants;
import java.util.List;

public class NumberLengthValidator {

    private static final String WRONG_LENGTH = "숫자는 3자릿수여야 합니다.";

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != NumberConstants.NUMBERS_LENGTH) {
            throw new IllegalArgumentException(WRONG_LENGTH);
        }
    }
}
