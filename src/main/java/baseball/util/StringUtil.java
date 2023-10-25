package baseball.util;

import static baseball.domain.GameConstants.NUMBER_LENGTH;

import baseball.domain.GameConstants;
import java.util.HashSet;
import java.util.Set;

public class StringUtil {

    private static final String TOO_SHORT_LENGTH_MESSAGE = String.format(
            "자리수가 %d보다 작습니다.",
            NUMBER_LENGTH);

    private static final String TOO_LONG_LENGTH_MESSAGE = String.format(
            "자리수가 %d보다 큽니다.",
            NUMBER_LENGTH);

    private static final String DUPLICATE_DIGITS_MESSAGE = "같은 숫자가 2개 이상 있습니다.";

    private static final String OUT_OF_RANGE_DIGITS_MESSAGE = String.format(
            "각 자리 숫자가 %d에서 %d 사이가 아닙니다.",
            GameConstants.MIN_DIGIT, GameConstants.MAX_DIGIT);


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

    public static void validateOutOfRange(String stringValue, int startRange, int endRange) {
        String regex = "^[" + startRange + "-" + endRange + "]+$";

        if (!stringValue.matches(regex)) {
            ExceptionUtil.throwInvalidValueException(OUT_OF_RANGE_DIGITS_MESSAGE);
        }
    }
}
