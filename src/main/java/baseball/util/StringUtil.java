package baseball.util;

import static baseball.domain.GameConstants.NUMBER_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class StringUtil {

    public static Set toHashSet(String string) {
        Set numSet = new HashSet();

        for (int i = 0; i < NUMBER_LENGTH; i++) {
            numSet.add(string.charAt(i));
        }
        return numSet;
    }

    public static String convertZeroToEmptyString(int value) {
        String stringValue = String.valueOf(value);
        if (value == 0) {
            stringValue = "";
        }
        return stringValue;
    }

    public static void validateShortLength(String string, int minLength) {
        if (string.length() < minLength) {
            ExceptionUtil.throwInvalidValueException(TOO_SHORT_LENGTH_MESSAGE);
        }
    }

    public static void validateLongLength(String string, int maxLength) {
        if (string.length() > maxLength) {
            ExceptionUtil.throwInvalidValueException(TOO_LONG_LENGTH_MESSAGE);
        }
    }

    public static void validateDuplicated(String string) {
        Set valueSet = StringUtil.toHashSet(string);

        if (valueSet.size() < NUMBER_LENGTH) {
            ExceptionUtil.throwInvalidValueException(DUPLICATE_DIGITS_MESSAGE);
        }
    }
}
