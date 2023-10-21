package baseball.io;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Validator {

    public static void validateNotEmpty(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("The list must not be null");
        }
    }

    public static void validateUniqueElements(List<Integer> list) {
        validateNotEmpty(list);

        Set<Integer> uniqueNumbers = new HashSet<>(list);
        if (uniqueNumbers.size() != list.size()) {
            throw new IllegalArgumentException("Duplicate numbers found in the list: " + list);
        }
    }

    public static void validateNumberRange(int targetNumber, int min, int max) {
        if (targetNumber < min || targetNumber > max) {
            throw new IllegalArgumentException("The number is out of the valid range");
        }
    }

    public static void validateDigit(String input, int length) {
        String regex = "^[1-9]{" + length + "}$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException("The input string has the invalid character");
        }
    }


    private Validator() {
    }

}
