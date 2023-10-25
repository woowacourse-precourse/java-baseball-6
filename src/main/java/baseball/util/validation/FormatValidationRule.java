package baseball.util.validation;

import baseball.util.ExceptionMessage;
import java.util.regex.Pattern;

public final class FormatValidationRule implements ValidationRule {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]+$");

    public static FormatValidationRule create() {
        return new FormatValidationRule();
    }

    @Override
    public void validate(String playerNumber) {
        if (!NUMBER_REGEX.matcher(playerNumber).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMERIC.getMessage());
        }
    }
}