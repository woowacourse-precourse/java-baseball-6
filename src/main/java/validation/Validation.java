package validation;

import static validation.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class Validation {
    public static void inputValidationCheck(String inputString) {
        verifyLength(inputString);
        isNumericString(inputString);
    }

    private static void verifyLength(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }
    }

    private static void isNumericString(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int askRestart() {
        int inputNumber = Integer.parseInt(Console.readLine());

        if (inputNumber > QUIT || inputNumber < RESTART) {
            throw new IllegalArgumentException(WRONG_INPUT_STRING);
        }
        return inputNumber;
    }
}
