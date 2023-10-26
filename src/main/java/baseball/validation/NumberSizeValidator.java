package baseball.validation;

import baseball.common.GameValue;
import java.util.List;

public class NumberSizeValidator {

    private NumberSizeValidator() {
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != GameValue.NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }

    public static void validate(String numbers) {
        if (numbers.length() != GameValue.NUMBER_SIZE.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }
}
