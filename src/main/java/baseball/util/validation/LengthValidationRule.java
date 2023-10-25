package baseball.util.validation;

import static baseball.util.Constants.BALL_LENGTH;

import baseball.util.ExceptionMessage;

public final class LengthValidationRule implements ValidationRule {

    public static LengthValidationRule create() {
        return new LengthValidationRule();
    }

    @Override
    public void validate(String playerNumber) {
        if (isInvalidLength(playerNumber.length(), BALL_LENGTH)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LENGTH.getMessage());
        }
    }

    private boolean isInvalidLength(int length, int targetLength) {
        return !(length == targetLength);
    }
}