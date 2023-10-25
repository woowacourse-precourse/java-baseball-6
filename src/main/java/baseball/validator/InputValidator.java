package baseball.validator;

import baseball.constant.ExceptionMessage;
import baseball.constant.GameConstant;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validateGameNumber(String input) {
        is3DigitsNumber(input);
        isConsistsOfUniqueDigits(input);
    }

    public static void validateRestartNumber(String input) {
        if (!input.matches(GameConstant.RESTART_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRES_1_OR_2.getMessage());
        }
    }

    private static void is3DigitsNumber(String input) {
        if (input.length() != GameConstant.GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRES_3_DIGITS.getMessage());
        }

        if (!input.matches(GameConstant.ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRES_1_BETWEEN_9.getMessage());
        }
    }

    private static void isConsistsOfUniqueDigits(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }

        if (set.size() != input.length()) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRES_UNIQUE_ELEMENTS.getMessage());
        }
    }
}