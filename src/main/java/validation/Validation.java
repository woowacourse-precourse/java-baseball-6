package validation;

import static validation.Constant.*;

public class Validation {
    public static void validationNumberCheck(String inputString) {
        if (inputString.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT_SIZE);
        }
        for (char c : inputString.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
