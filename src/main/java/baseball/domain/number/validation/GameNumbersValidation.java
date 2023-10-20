package baseball.domain.number.validation;

import baseball.computer.ComputerConstants;
import java.util.Collections;
import java.util.List;

public class GameNumbersValidation {

    private static final String WRONG_LENGTH = "숫자는 3자릿수여야 합니다.";
    private static final String DUPLICATE_NUMBER = "중복된 숫자가 입력되었습니다.";

    public static void validate(List<Integer> numbers) {
        validateLength(numbers);
        checkDuplicateNumbers(numbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != ComputerConstants.NUMBERS_LENGTH) {
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
}
