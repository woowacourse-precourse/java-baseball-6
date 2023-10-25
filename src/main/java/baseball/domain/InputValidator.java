package baseball.domain;

import static baseball.constant.GameConstants.*;

import baseball.constant.GameStatus;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private InputValidator() {
    }

    public static void numberInput(String inputString) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }

        if (inputString.length() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }

        if (!hasUniqueNumber(inputString)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }

        if (!hasValidNumber(inputString)) {
            throw new IllegalArgumentException(ERROR_INVALID_INPUT + "#");
        }
    }

    public static void continueInput(String inputContinue) throws IllegalArgumentException {
        if (!inputContinue.equals(GameStatus.CONTINUE.status) && !inputContinue.equals(
                GameStatus.STOP.status)) {
            throw new IllegalArgumentException(ERROR_INVALID_CONTINUE_INPUT);
        }
    }

    private static boolean hasValidNumber(String inputString) {
        return inputString.chars()
                .allMatch(ch -> ch >= '0' + MIN_NUMBER && ch <= '0' + MAX_NUMBER);
    }

    private static boolean hasUniqueNumber(String inputString) {
        Set<Character> set = new HashSet<>();
        for (char s : inputString.toCharArray()) {
            set.add(s);
        }
        return set.size() == MAX_NUMBER_LENGTH;
    }
}
