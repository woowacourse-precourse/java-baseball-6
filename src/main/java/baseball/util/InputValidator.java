package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static baseball.util.ErrorMessage.*;
import static baseball.util.ExceptionHandler.triggerException;

public class InputValidator {
    private static final int PLAYER_INPUT_LENGTH = 3;

    public static void validatePlayerNumberInput(String input) {
        if (input.length() != PLAYER_INPUT_LENGTH) {
            triggerException(PLAYER_INPUT_NUMBER_NOT_3_DIGIT);
        }

        if (hasDuplicateNumber(input)) {
            triggerException(PLAYER_INPUT_NUMBER_DUPLICATE_NUMBER);
        }

        if (!isIncludedInRange(input)) {
            triggerException(PLAYER_INPUT_NUMBER_NOT_GIVEN_RANGE);
        }

        if (!isConvertableToInteger(input)) {
            triggerException(PLAYER_INPUT_NUMBER_NOT_A_NUMBER);
        }
    }

    private static boolean hasDuplicateNumber(String input) {
        return Arrays.stream(input.split(""))
                .distinct()
                .count() != PLAYER_INPUT_LENGTH;
    }

    private static boolean isConvertableToInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isIncludedInRange(String input) {
        return Pattern.matches("^[1-9]{3}$", input);
    }

    public static String convertListToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
