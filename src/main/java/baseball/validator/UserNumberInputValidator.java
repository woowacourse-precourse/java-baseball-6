package baseball.validator;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.exception.ErrorMessage.INVALID_USER_NUMBER_INPUT_FORMAT;

public class UserNumberInputValidator {
    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_USER_NUMBER_INPUT_FORMAT.getMessage());
        }
    }

    public static List<Integer> convertToIntegerList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
