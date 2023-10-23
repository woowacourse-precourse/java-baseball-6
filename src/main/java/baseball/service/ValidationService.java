package baseball.service;

import baseball.util.ExceptionHandler;
import java.util.HashSet;
import java.util.Set;

public class ValidationService {
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    public void isValidNumber(String str) {
        isThreeDigits(str);
        hasNoZero(str);
        hasUniqueDigits(str);
        isNumeric(str);
    }

    public void isThreeDigits(String str) {
        if (!(str.length() == 3)) {
            exceptionHandler.throwIfNumberLengthNotThree();
        }
    }

    public void hasNoZero(String str) {
        if (str.contains("0")) {
            exceptionHandler.throwIfNumberHasZero();
        }
    }

    private void hasUniqueDigits(String str) {
        char[] digits = str.toCharArray();
        Set<Character> uniqueSet = new HashSet<>();

        for (char digit : digits) {
            if (uniqueSet.contains(digit)) {
                exceptionHandler.throwIfNumberIsDuplicated();
            }
            uniqueSet.add(digit);
        }
    }

    public void isNumeric(String str) {
        if (!str.matches("\\d+")) {
            exceptionHandler.throwIfStringIsNotNumeric();
        }
    }
}
