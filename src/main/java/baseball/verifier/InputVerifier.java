package baseball.verifier;

import baseball.system.SystemConstant;
import baseball.system.SystemException;

public class InputVerifier {
    public void checkBallNumber(String isBallNumber) throws IllegalArgumentException {
        checkNumeric(isBallNumber);
        checkRange(isBallNumber);
        checkDistinct(isBallNumber);
    }

    private void checkNumeric(String isNumeric) {
        try {
            Integer.parseInt(isNumeric);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_NUMERIC);
        }
    }

    private void checkRange(String inRange) {
        if (Integer.parseInt(inRange) < 123 || 987 < Integer.parseInt(inRange)) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_RANGE);
        }
    }

    private void checkDistinct(String isDistinct) {
        if (isDistinct.chars()
                .distinct()
                .count() != SystemConstant.MAXIMUM_DIGIT) {
            throw new IllegalArgumentException(SystemException.EXCEPTION_DISTINCT);
        }
    }
}
