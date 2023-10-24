package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.constant.MessageConstant.*;
import static baseball.constant.SystemConstant.*;

public class InputValidator {
    public static void validateCheckRestartGameInput(String input) {
        if (!(input.equals(GAME_RESTART_NUMBER) || input.equals(GAME_END_NUMBER))) {
            throw new IllegalArgumentException(GAME_RESTART_INPUT_ERROR);
        }
    }

    public static void validatePlayerInput(String input) {
        if (!checkLength(input)) {
            throw new IllegalArgumentException(PLAYER_INPUT_LENGTH_ERROR);
        }

        if (!checkNumberType(input)) {
            throw new IllegalArgumentException(PLAYER_INPUT_NUMBER_TYPE_ERROR);
        }

        if (!checkDuplicateNumber(input)) {
            throw new IllegalArgumentException(PLAYER_INPUT_NUMBER_DUPLICATE_ERROR);
        }
    }

    private static boolean checkLength(String input) {
        return input.length() == NUMBER_LENGTH;
    }

    private static boolean checkNumberType(String input) {
        return Pattern.matches(NUMBER_PATTERN, input);
    }

    private static boolean checkDuplicateNumber(String input) {
        Set<String> numberSet = new HashSet<>(List.of(input.split("")));
        return numberSet.size() == input.length();
    }
}
