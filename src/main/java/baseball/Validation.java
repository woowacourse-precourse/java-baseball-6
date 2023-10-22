package baseball;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    private static final int ZERO = 0;
    private static final int RESTART_NUMBER = 1;
    private static final int QUIT_NUMBER = 2;
    private static final int CORRECT_INPUT_RANGE = 3;

    public void inputValidation(String inputString) {
        Set<Character> inputArr = new HashSet<>();
        for (char c : inputString.toCharArray()) {
            if (!Character.isDigit(c) || Character.getNumericValue(c) == ZERO) {
                throw new IllegalArgumentException();
            }
            inputArr.add(c);
        }

        if (inputArr.size() != CORRECT_INPUT_RANGE) {
            throw new IllegalArgumentException();
        }
    }

}
