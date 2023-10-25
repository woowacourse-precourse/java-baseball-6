package baseball.validator;

import baseball.message.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEX = "^[0-9]+$";

    public void validateIsDigit(String number) {
        if (!Pattern.matches(REGEX, number)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT.toString());
        }
    }
}
