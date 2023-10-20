package baseball.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String NUMBER_REGEX = "^[1-9]$";
    private static final Integer INPUT_LENGTH = 3;

    public boolean validateNumber(String number) {
        if(isRightNumber(number))
            return true;
        throw new IllegalArgumentException("Error");
    }

    private boolean isRightNumber(String number) {
        return number.matches(NUMBER_REGEX) && number.length() == INPUT_LENGTH;
    }
}
