package baseball.util;

import java.util.Collection;

public class Assertions {
    public static <E extends Comparable<? super E>>
    void assertInRange(E value, E startInclusive, E endInclusive) throws IllegalArgumentException {
        if (0 <= value.compareTo(startInclusive) && value.compareTo(endInclusive) <= 0) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static <E extends Comparable<? super E>>
    void assertEqual(E lhs, E rhs) throws IllegalArgumentException {
        if (lhs.compareTo(rhs) == 0) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static <E>
    void assertExistsIn(E needle, Collection<E> hay) {
        if (hay.contains(needle)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static <E extends Object>
    void assertNotNull(E value) {
        if (value != null) {
            return;
        }
        throw new NullPointerException();
    }
}
