package baseball.utils;

import java.util.List;

public class ListUtils {

    private ListUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isLengthEqual(final List<?> value, int length) {
        if (value == null || length < 0) {
            throw new IllegalArgumentException();
        }

        return value.size() == length;
    }
}
