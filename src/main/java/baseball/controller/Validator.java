package baseball.controller;

import baseball.constants.NumberConstants;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static Validator validator = new Validator();

    private Validator() {
    }

    static Validator getInstance() {
        return validator;
    }

    public void checkValidInput(String input) {
        String regex = String.format("^[%d-%d]{%d}$", NumberConstants.MIN, NumberConstants.MAX, NumberConstants.SIZE);
        boolean isValid = input.matches(regex) && !isDuplicated(input);

        if (!isValid) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(String input) {
        Set<Character> set = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!set.add(c)) {
                return true;
            }
        }
        return false;
    }

    public void checkValidAnswer(String answer) {
        String regex = String.format("^[%d-%d]$", NumberConstants.START_NUM, NumberConstants.END_NUM);

        if (!answer.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
