package baseball.validator;

import baseball.constants.InputPattern;
import java.util.regex.Pattern;

public class RegexValidator {

    private RegexValidator() {
        throw new AssertionError();
    }

    public static void validate(InputPattern inputPattern, String string) {
        Pattern pattern = inputPattern.getPattern();

        if (!pattern.matcher(string).matches()) {
            throw new IllegalArgumentException(inputPattern.getErrorMessage());
        }
    }
}