package baseball.validator;

import baseball.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    public void validateIsNumber(String input) {
        String NUMBER_REGEXP = "^\\d*$";
        if (!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
