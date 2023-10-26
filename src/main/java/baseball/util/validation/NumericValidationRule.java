package baseball.util.validation;

import baseball.util.ExceptionMessage;

public final class NumericValidationRule implements ValidationRule {
    public NumericValidationRule() {
    }

    public static NumericValidationRule create() {
        return new NumericValidationRule();
    }

    @Override
    public void validate(String playerNumber) {
        try {
            Integer.parseInt(playerNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE.getMessage());
        }
    }
}