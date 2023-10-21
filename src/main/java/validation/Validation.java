package validation;

import static validation.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class Validation {
    public static void inputValidationCheck(String inputString) {
        verifyLength(inputString);
        isNumericString(inputString);
        hasDuplicateInteger(inputString);
    }

    private static void verifyLength(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }
    }

    private static void isNumericString(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(HAS_CHAR_INPUT);
            }
        }
    }

    private static void hasDuplicateInteger(String input) {
        Set<String> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            String currentChar = String.valueOf(c);
            if (seen.contains(currentChar)) {
                throw new IllegalArgumentException(DUPLICATED_STRING);
            }
            seen.add(currentChar);
        }
    }

    public static int askRestart() {
        int inputNumber = Integer.parseInt(Console.readLine());

        if (inputNumber > QUIT || inputNumber < RESTART) {
            throw new IllegalArgumentException(WRONG_RESTART_INPUT);
        }
        return inputNumber;
    }
}
