package baseball.utils;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    static final int MIN_NUMBER = 1;
    static final int RIGHT_LENGTH_NUMBER = 3;
    static final int GAME_END_MARK = 2;
    static final int GAME_RESTART_MARK = 1;

    public void validateNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateUnderOne(String input) {
        for (char c : input.toCharArray()) {
            int toInt = c - '0';
            if (toInt < MIN_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateNumberLengthThree(String input) {
        if (input.length() != RIGHT_LENGTH_NUMBER) {
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
        int toInt = Integer.parseInt(input);
        if (toInt != GAME_RESTART_MARK && toInt != GAME_END_MARK) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberLengthOne(String input) {
        if (input.length() != MIN_NUMBER) {
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
