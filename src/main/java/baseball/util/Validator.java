package baseball.util;

import static java.util.regex.Pattern.matches;

import baseball.exception.view.InputBlankException;
import baseball.exception.view.InputCanNotChangeToIntException;

public class Validator {

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    private Validator() {
    }

    public static void checkIsBlank(final String string) {
        if (string.isBlank()) {
            throw new InputBlankException();
        }
    }

    public static void checkCanChangeToInteger(final String string) {
        if (!matches(REGEXP_PATTERN_NUMBER, string)) {
            throw new InputCanNotChangeToIntException(string);
        }
    }
}
