package baseball.util;

import baseball.constant.GameConstants;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static void validatePlayerInputNumber(String playerInputNumber) {
        if (!validateInputLength(playerInputNumber)) {
            throw new IllegalArgumentException(); //TODO: Custom Exception
        }

        if (!validateInputIsNumber(playerInputNumber)) {
            throw new NumberFormatException(); //TODO: Custom Exception
        }

        if (!validateInputDuplication(playerInputNumber)) {
            throw new IllegalArgumentException(); //TODO: Custom Exception
        }
    }

    public static void validateRetryOrEndFlag(String flag) {
        if (flag.equals(GameConstants.RETRY) || flag.equals(GameConstants.END)) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private static boolean validateInputLength(String input) {
        return input.length() == GameConstants.BALL_COUNT;
    }

    private static boolean validateInputIsNumber(String input) {
        return input.matches(GameConstants.NUMBER_REGX);
    }

    private static boolean validateInputDuplication(String input) {
        Set<Character> set = new HashSet<>();
        for (Character c : input.toCharArray()) {
            set.add(c);
        }

        return set.size() == GameConstants.BALL_COUNT;
    }
}
