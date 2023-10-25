package baseball;

import static baseball.GameStatus.END;
import static baseball.GameStatus.START;
import static baseball.Message.DUPLICATE_INPUT_MESSAGE;
import static baseball.Message.INVALID_INPUT_MESSAGE;
import static baseball.Message.LENGTH_ERROR_MESSAGE;
import static baseball.Message.RESTART_ERROR_MESSAGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public void validateGuess(String[] input) {
        checkLength(input);
        checkRange(input);
        checkDuplication(input);
    }

    public void validateOption(String input) {
        if (!input.equals(START) && !input.equals(END)) {
            throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
        }
    }

    public void checkLength(String[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    public void checkRange(String[] input) {
        for (String s : input) {
            if (!isValidNumber(Integer.valueOf(s))) {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
    }

    public void checkDuplication(String[] input) {
        Set<String> set = new HashSet<>(List.of(input));
        if (input.length != set.size()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
        }
    }

    public boolean isValidNumber(Integer i) {
        return i >= 1 && i <= 9;
    }
}
