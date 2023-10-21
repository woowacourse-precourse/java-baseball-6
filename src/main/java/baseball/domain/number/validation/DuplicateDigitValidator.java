package baseball.domain.number.validation;

import java.util.Collections;
import java.util.List;

public class DuplicateDigitValidator {

    private static final String DUPLICATE_NUMBER = "중복된 숫자가 입력되었습니다.";

    public static void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER);
            }
        }
    }
}
