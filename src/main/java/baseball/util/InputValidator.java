package baseball.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    public static void validateInput(String regex, String number) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
