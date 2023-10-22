package baseball.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern playerNumberValidationPattern = Pattern.compile("^(?!.*(.).*\\1)[1-9]{3}$");
    private static final Pattern oneOrTwoPattern = Pattern.compile("^[12]$");

    public static void isValidPlayerNumber(String number) {
        Matcher matcher = playerNumberValidationPattern.matcher(number);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidRestartOrEndNumber(String number) {
        Matcher matcher = oneOrTwoPattern.matcher(number);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
