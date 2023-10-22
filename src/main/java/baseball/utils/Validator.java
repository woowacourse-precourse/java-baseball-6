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
}
