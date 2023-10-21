package baseball.verifier;

import baseball.system.SystemConstant;
import baseball.system.SystemException;

public class InputVerifier {
    public static void checkBallNumber(String isBallNumber) throws IllegalArgumentException {
        checkNumeric(isBallNumber);
        checkRange(isBallNumber);
        checkDistinct(isBallNumber);
        checkHasZero(isBallNumber);
    }

    public static void checkGameNumber(String isGameNumber) throws IllegalArgumentException {
        if (!isGameNumber.equals(SystemConstant.NEW_GAME) && !isGameNumber.equals(SystemConstant.END_GAME)) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_GAME_NUMBER);
        }
    }

    private static void checkNumeric(String isNumeric) {
        try {
            Integer.parseInt(isNumeric);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_NUMERIC);
        }
    }

    private static void checkRange(String inRange) {
        if (inRange.length() != SystemConstant.MAXIMUM_DIGIT) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_RANGE);
        }
    }

    private static void checkHasZero(String inRange) {
        if (inRange.contains("0")) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_HAS_ZERO);
        }
    }

    private static void checkDistinct(String isDistinct) {
        if (isDistinct.chars()
                .distinct()
                .count() != SystemConstant.MAXIMUM_DIGIT) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_DISTINCT);
        }
    }
}
