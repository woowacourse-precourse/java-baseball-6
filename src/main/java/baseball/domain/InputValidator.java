package baseball.domain;

import static baseball.constant.GameConstants.*;

import baseball.constant.GameStatus;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputValidator {
    private InputValidator() {
    }

    public static void numberInput(String inputString) throws IllegalArgumentException {
        if (!Pattern.matches(INPUT_REGEX, inputString) || !hasUniqueNumber(inputString)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT + inputString);
        }
    }

    public static void continueInput(String inputContinue) throws IllegalArgumentException {
        if (!inputContinue.equals(GameStatus.CONTINUE.status) && !inputContinue.equals(
                GameStatus.STOP.status)) {
            throw new IllegalArgumentException(ERROR_INVALID_CONTINUE_INPUT);
        }
    }

    private static boolean hasUniqueNumber(String inputString) {
        Set<Character> set = new HashSet<>();
        for (char s : inputString.toCharArray()) {
            set.add(s);
        }
        return set.size() == MAX_NUMBER_LENGTH;
    }
}
