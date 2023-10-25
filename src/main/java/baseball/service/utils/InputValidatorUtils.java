package baseball.service.utils;

import java.util.HashSet;
import java.util.Set;

public class InputValidatorUtils {

    private static final int BASEBALL_GAME = 3;
    private static final int NEW_GAME_START = 1;

    public boolean isValidInput(String input, int inputType) {
        if (inputType == BASEBALL_GAME) {
            if (input.length() == BASEBALL_GAME && isNum(input) && !isDuplicated(input)) {
                return true;
            } else {
                return false;
            }
        } else if (inputType == NEW_GAME_START) {
            if (input.length() == NEW_GAME_START && isRestartOrExit(input) && !isDuplicated(input)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean isNum(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || c == '0') {
                return false;
            }
        }
        return true;
    }

    public boolean isDuplicated(String input) {
        String[] nums = input.split("");
        Set<String> set = new HashSet<>();

        for (String num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRestartOrExit(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c) && (c == '1' || c == '2')) {
                return true;
            }
        }
        return false;
    }

}
