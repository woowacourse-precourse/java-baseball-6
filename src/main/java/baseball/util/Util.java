package baseball.util;

import java.util.List;

public class Util {

    protected Util() {}
    public static boolean validNumberType(Object o) {
        if (o instanceof Integer) {
            return true;
        }
        return false;
    }

    public static boolean validNumberRange(int min, int max, int value) {
        if (value >= min && value <= max) {
            return true;
        }
        return false;
    }

    public static boolean validDuplicatedNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream()
                .distinct()
                .count()) {
            return false;
        }
        return true;
    }
}
