package baseball.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isNumeric(final String value) {
        if (StringUtils.isLengthEqual(value, 0)) {
            return false;
        }

        return value.chars().allMatch(Character::isDigit);
    }

    public static boolean isLengthEqual(final String value, final int length) {
        if (length < 0) {
            throw new IllegalArgumentException();
        }
        return value.length() == length;
    }

    public static boolean hasDuplicate(final String value) {
        return value.length() != Arrays.stream(value.split("")).collect(Collectors.toSet()).size();
    }


}
