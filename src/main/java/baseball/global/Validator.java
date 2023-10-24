package baseball.global;

import static baseball.global.constant.BaseballGameConstant.*;
import static baseball.global.constant.ExceptionMessage.*;

import baseball.global.constant.ExceptionMessage;
import java.util.HashSet;
import java.util.List;

public class Validator {

    public static void validateRestart(String input) {
        if (!input.equals(IS_RESTART) && !input.equals(IS_STOP)) {
            throw new IllegalArgumentException(INVALID_RESTART_OPTION_MESSAGE);
        }
    }

    public static void validatePlayerInput(String[] input) {
        validateInputLength(input);
        validateDuplicatedInput(input);
        validateNumbersFormat(input);
    }

    public static void validateInputLength(String[] input) {
        if (input.length != PLAY_COUNT) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH_MESSAGE);
        }
    }

    public static void validateDuplicatedInput(String[] input) {
        HashSet<String> set = new HashSet<>(List.of(input));
        if (set.size() != input.length) {
            throw new IllegalArgumentException(DUPLICATED_INPUT_MESSAGE);
        }
    }

    public static void validateNumbersFormat(String[] numbers) {
        for (String number : numbers) {
            validateNumberFormat(number);
        }
    }

    public static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
        }
    }
}
