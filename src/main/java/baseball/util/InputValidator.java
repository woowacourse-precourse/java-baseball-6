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

    private static boolean validateInputLength(String inputBalls) {
        return inputBalls.length() == GameConstants.BALL_COUNT;
    }

    private static boolean validateInputIsNumber(String inputBalls) {
        return inputBalls.matches(GameConstants.NUMBER_REGX);
    }

    private static boolean validateInputDuplication(String inputBalls) {
        Set<Character> set = new HashSet<>();
        for (Character c : inputBalls.toCharArray()) {
            set.add(c);
        }

        return set.size() == GameConstants.BALL_COUNT;
    }
}
