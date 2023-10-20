package baseball.util;

public class Assertions {
    public static <E extends Comparable<? super E>>
    void assertInRange(E value, E startInclusive, E endInclusive) throws IllegalArgumentException {
        if (value.compareTo(startInclusive) < 0 || value.compareTo(endInclusive) > 0) {
            throw new IllegalArgumentException();
        }
    }

    public static <E extends Object>
    void assertNotNull(E value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }
}
