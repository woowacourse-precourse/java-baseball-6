package baseball.util.validator;

import java.util.HashSet;

public class InputValidator {
    public void checkInputValidation(String inputNumber) {
        checkDuplication(inputNumber);
        checkRangeOfNumber(inputNumber);
        checkIsNumber(inputNumber);
    }

    private void checkDuplication(String inputNumber) {
        HashSet<Character> set = new HashSet<>();
        for (char alpha : inputNumber.toCharArray()) {
            set.add(alpha);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkRangeOfNumber(String inputNumber) {
        for (char alpha : inputNumber.toCharArray()) {
            if (alpha - '0' < 1 || alpha - '0' > 9) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkIsNumber(String inputNumber) {
        for (char alpha : inputNumber.toCharArray()) {
            if (!Character.isDigit(alpha)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
