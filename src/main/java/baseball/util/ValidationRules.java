package baseball.util;

import static baseball.util.Constants.BALL_LENGTH;

import java.util.regex.Pattern;

public class ValidationRules implements ValidationRule {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]+$");

    public static ValidationRules createValidationRules() {
        return new ValidationRules();
    }

    @Override
    public void FormatValidationRule(String playerNumber) {
        if (!NUMBER_REGEX.matcher(playerNumber).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
        }
    }

    @Override
    public void NumericValidationRule(String playerNumber) {
        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE.getMessage());
        }
    }

    @Override
    public void LengthValidationRule(String playerNumber) {
        if (isLengthThree(playerNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LENGTH.getMessage());
        }
    }

    private static boolean isLengthThree(String playerNumber) {
        return playerNumber.length() != BALL_LENGTH;
    }
}
