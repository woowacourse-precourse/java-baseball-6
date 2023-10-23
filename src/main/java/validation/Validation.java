package validation;

import static validation.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void inputValidationCheck(String inputString) {
        validateLength(inputString);
        isNumericString(inputString);
        hasDuplicateInteger(inputString);
    }

    private static void validateLength(String input) throws IllegalArgumentException {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }
    }

    private static void isNumericString(String input) throws IllegalArgumentException {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(HAS_CHAR_INPUT);
            }
        }
    }

    private static void hasDuplicateInteger(String input) throws IllegalArgumentException {
        Set<String> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            String currentChar = String.valueOf(c);
            if (seen.contains(currentChar)) {
                throw new IllegalArgumentException(DUPLICATED_STRING);
            }
            seen.add(currentChar);
        }
    }

    public static void validateRestart(int restart) throws IllegalArgumentException {
        if (restart > QUIT || restart < RESTART) {
            throw new IllegalArgumentException(WRONG_RESTART_INPUT);
        }
    }
}
