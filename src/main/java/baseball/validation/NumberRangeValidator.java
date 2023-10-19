package baseball.validation;

import baseball.exception.NumberRangeException;
import baseball.view.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberRangeValidator {

    private NumberRangeValidator() {
    }

    public static void validate(String number) {
        Pattern pattern = Pattern.compile(RegexPattern.ONE_TO_NINE.getValue());
        Matcher matcher = pattern.matcher(number);

        if (!matcher.matches()) {
            throw new NumberRangeException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }
}
