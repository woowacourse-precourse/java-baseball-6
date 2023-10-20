package baseball.validation;

import baseball.view.ErrorMessage;
import baseball.view.RegexPattern;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFormatValidator {

    private NumberFormatValidator() {
    }

    public static void validate(String number) {
        Pattern pattern = Pattern.compile(RegexPattern.ONLY_NUMBER.getValue());
        Matcher matcher = pattern.matcher(number);

        if (!matcher.matches()) {
            throw new NumberFormatException(ErrorMessage.NUMBER_TYPE.getMessage());
        }
    }
}
