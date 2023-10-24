package baseball.verifier;

import baseball.system.SystemConstant;
import baseball.system.SystemException;

public class InputVerifier {
    public static void checkBallNumber(String ballNumber) throws IllegalArgumentException {
        checkNumeric(ballNumber);
        checkRange(ballNumber);
        checkDistinct(ballNumber);
        checkDigitRange(ballNumber);
    }

    public static void checkGameNumber(String gameNumber) throws IllegalArgumentException {
        if (!gameNumber.equals(SystemConstant.NEW_GAME) && !gameNumber.equals(SystemConstant.END_GAME)) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_GAME_NUMBER);
        }
    }

    private static void checkNumeric(String ballNumber) {
        try {
            Integer.parseInt(ballNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_NUMERIC);
        }
    }

    private static void checkRange(String ballNumber) {
        if (ballNumber.length() != SystemConstant.DIGIT_SIZE) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_RANGE);
        }
    }

    private static void checkDigitRange(String ballnumber) {
        ballnumber.chars()
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

    private static void checkDistinct(String ballNumber) {
        if (ballNumber.chars()
                .distinct()
                .count() != ballNumber.length()) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_DISTINCT);
        }
    }
}
