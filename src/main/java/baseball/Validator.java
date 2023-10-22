package baseball;

import static baseball.Constants.*;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    void numberInput(String inputString) throws IllegalArgumentException {
        if (!Pattern.matches(INPUT_REGEX, inputString) || !hasUniqueNumber(inputString)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT + inputString);
        }
    }

    void continueInput(String inputContinue) throws IllegalArgumentException {
        if (!inputContinue.equals(CONTINUE) && !inputContinue.equals(Constants.STOP)) {
            throw new IllegalArgumentException(ERROR_INVALID_CONTINUE_INPUT);
        }
    }

    private boolean hasUniqueNumber(String inputString) {
        Set<Character> set = new HashSet<>();
        for (char s : inputString.toCharArray()) {
            set.add(s);
        }
        return set.size() == MAX_NUMBER_LENGTH;
    }
}
