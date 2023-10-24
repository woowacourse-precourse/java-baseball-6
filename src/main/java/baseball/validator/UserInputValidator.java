package baseball.validator;

import baseball.constans.ErrorMessage;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class UserInputValidator {

    private UserInputValidator() {
    }

    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+$");

    public static void validateIsNumberAndRange(String userInput) {

        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public static void validateLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_LENGTH_EXCEPTION.getMessage());
        }
    }

    public static void validateFinishOrRestart(String userInput) {
        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_CORRECT_EXCEPTION.getMessage());
        }
    }

    public static void validateDuplicate(String userInput) {
        List<Integer> list = Arrays.stream(userInput.split("")).map(Integer::parseInt).toList();
        for (Integer i : list) {
            if (Collections.frequency(list, i) > 1) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED_EXCEPTION.getMessage());
            }
        }

    }
}
