package baseball;

import java.util.regex.Pattern;

public class Validate {
    private static void validateNumber(String number) {
        String regex = "[1-9]{1,3}";
        if (!Pattern.matches(regex, number)) {
            throw new IllegalArgumentException();
        }
    }

}