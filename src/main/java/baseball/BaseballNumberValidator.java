package baseball;

import static baseball.BaseballConstants.*;

import java.util.HashSet;
import java.util.Set;

public class BaseballNumberValidator implements Validator {

    public static final String START_DIGIT = "1";
    public static final String END_DIGIT = "9";

    @Override
    public void validate(String input) {
        if (isDuplicate(input) || !isOnlyNum(input)) {
            throw new IllegalArgumentException(VALIDATE_ERROR_MESSAGE);
        }
    }

    private boolean isOnlyNum(String input) {
        if (input.matches(
            "[" + START_DIGIT + "-" + END_DIGIT + "]{" + BASEBALL_NUMBER_SIZE + "}")) {
            return true;
        }
        return false;
    }

    private boolean isDuplicate(String input) {
        Set<Character> history = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (history.contains(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
