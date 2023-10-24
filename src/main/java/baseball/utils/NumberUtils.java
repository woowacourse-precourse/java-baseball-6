package baseball.utils;

public class NumberUtils {

    private NumberUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isWithInRange(final int target,
                                        final int start,
                                        final int end) {
        if (start > end) throw new IllegalArgumentException();
        return target >= start && target <= end;
    }

}
