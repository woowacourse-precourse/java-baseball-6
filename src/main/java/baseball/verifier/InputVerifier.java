package baseball.verifier;

import baseball.system.SystemConstant;
import baseball.system.SystemException;

public class InputVerifier {
    public static void checkBallNumber(String isBallNumber) throws IllegalArgumentException {
        checkNumeric(isBallNumber);
        checkRange(isBallNumber);
        checkDistinct(isBallNumber);
        checkDigitRange(isBallNumber);
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
        if (inRange.length() != SystemConstant.DIGIT_SIZE) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_RANGE);
        }
    }

    private static void checkDigitRange(String inRange) {
        inRange.chars()
                .map(Character::getNumericValue)
                .forEach(InputVerifier::outOfEachDigitRange);
    }

    private static void outOfEachDigitRange(int comp) {
        throwIfLower(comp);
        throwIfHigher(comp);
    }

    private static void throwIfLower(int comp) {
        if (comp < SystemConstant.MIN_NUMBER_EACH_DIGIT) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_EACH_DIGIT_RANGE);
        }
    }

    private static void throwIfHigher(int comp) {
        if (comp > SystemConstant.MAX_NUMBER_EACH_DIGIT) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_EACH_DIGIT_RANGE);
        }
    }

    private static void checkDistinct(String isDistinct) {
        if (isDistinct.chars()
                .distinct()
                .count() != isDistinct.length()) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_DISTINCT);
        }
    }
}
