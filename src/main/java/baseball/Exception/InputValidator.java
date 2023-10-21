package baseball.Exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private final String NUMBER_REGEX = "^[1-9]+$";
    private final String RESTART_COMMAND = "1";
    private final String QUIT_COMMAND = "2";
    private final int AVAIL_LENGTH = 3;

    public void doValidate(String input) {
        if (!isThreeLength(input)) {
            throw new IllegalArgumentException(InputException.NOT_THREE.getMessage());
        }

        if (!isNumberString(input)) {
            throw new IllegalArgumentException(InputException.NOT_NUMBER.getMessage());
        }

        if (hasDupNum(input)) {
            throw new IllegalArgumentException(InputException.HAS_DUPLICATE_NUMBER.getMessage());
        }
    }

    public void validateCommand(String command) {
        if (!isCommand(command)) {
            throw new IllegalArgumentException(InputException.WRONG_COMMAND.getMessage());
        }
    }

    private boolean isCommand(String command) {
        return command.equals(RESTART_COMMAND) || command.equals(QUIT_COMMAND);
    }

    private boolean isThreeLength(String input) {
        return input.length() == AVAIL_LENGTH;
    }

    private boolean isNumberString(String input) {
        return input.matches(NUMBER_REGEX);
    }

    private boolean hasDupNum(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!set.add(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }


}
