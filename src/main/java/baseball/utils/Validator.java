package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public void validateNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateUnderOne(String input) {
        for (char c : input.toCharArray()) {
            int tmp = c - '0';
            if (tmp < 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateNumberLengthThree(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberDuplication(String input) {
        Set<Character> tmp = new HashSet<>();
        for (char c : input.toCharArray()) {
            tmp.add(c);
        }
        if (tmp.size() != input.length()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberOneOrTwo(String input) {
        int tmp = Integer.parseInt(input);
        if (tmp != 1 && tmp != 2) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberLengthOne(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
    }

    public void validateGetUserGameNumber(String input) {
        validateNumeric(input);
        validateUnderOne(input);
        validateNumberLengthThree(input);
        validateNumberDuplication(input);
    }

    public void validateGetUserGameContinue(String input) {
        validateNumeric(input);
        validateNumberOneOrTwo(input);
        validateNumberLengthOne(input);
    }
}
