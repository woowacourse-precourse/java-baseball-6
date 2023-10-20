package baseball.domain.number.validation;

import baseball.computer.ComputerConstants;
import java.util.List;

public class GameNumbersValidation {

    private static final String WRONG_LENGTH = "숫자는 3자릿수여야 합니다.";

    public static void validate(List<Integer> numbers) {
        validateLength(numbers);
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != ComputerConstants.NUMBERS_LENGTH) {
            throw new IllegalArgumentException(WRONG_LENGTH);
        }
    }
}
