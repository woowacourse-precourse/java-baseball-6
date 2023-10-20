package validation;

import camp.nextstep.edu.missionutils.Console;

import static validation.Constant.*;

public class Validation {
    public static void inputValidationCheck(String inputString) {
        if (inputString.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }
        for (char c : inputString.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static int askRestart() {
        int inputNumber = Integer.parseInt(Console.readLine());

        if (inputNumber > QUIT || inputNumber < RESTART) {
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }
        return inputNumber;
    }
}
