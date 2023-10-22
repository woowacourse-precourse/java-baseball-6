package baseball;

import static baseball.constant.GameConstants.*;

import baseball.constant.GameStatus;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    public void numberInput(String inputString) throws IllegalArgumentException {
        if (!Pattern.matches(INPUT_REGEX, inputString) || !hasUniqueNumber(inputString)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT + inputString);
        }
    }

    public void continueInput(String inputContinue) throws IllegalArgumentException {
        if (!inputContinue.equals(GameStatus.CONTINUE.getStatus()) && !inputContinue.equals(
                GameStatus.STOP.getStatus())) {
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
