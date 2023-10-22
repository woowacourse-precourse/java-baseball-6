package baseball.service;

import java.util.HashSet;
import java.util.Set;

public class ValidationService {
    public void isValidNumber(String str) {
        if (isThreeDigits(str) && hasNoZero(str) && hasUniqueDigits(str) && isNumeric(str)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private boolean isThreeDigits(String str) {
        return str.length() == 3;
    }

    private boolean hasNoZero(String str) {
        return !str.contains("0");
    }

    private boolean hasUniqueDigits(String str) {
        char[] digits = str.toCharArray();
        Set<Character> uniqueSet = new HashSet<>();

        for (char digit : digits) {
            if (uniqueSet.contains(digit)) {
                return false;
            }
            uniqueSet.add(digit);
        }
        return true;
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
