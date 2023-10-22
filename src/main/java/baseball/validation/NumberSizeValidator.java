package baseball.validation;

import baseball.view.ErrorMessage;
import java.util.List;

public class NumberSizeValidator {

    private NumberSizeValidator() {
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }

    public static void validate(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }
}
