package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class NumberValidator {

    public static void assertInputNumberWithLength(final String input, final int length) {
        assertNumberValue(input);
        assertDigitLength(input, length);
        assertEachNumberUnique(input);
    }

    private static void assertNumberValue(final String input) {
        if (!input.matches("^[1-9]+$")) {
            throw new IllegalArgumentException();
        }
    }

    private static void assertDigitLength(final String inputNumber, final int expectedDigitLength) {
        if (inputNumber.length() != expectedDigitLength) {
            throw new IllegalArgumentException();
        }
    }

    private static void assertEachNumberUnique(final String input) {
        Set<Character> inputSet = new HashSet<>();
        char[] inputArray = input.toCharArray();

        for (char word : inputArray) {
            inputSet.add(word);
        }

        if (inputSet.size() != input.length()) {
            throw new IllegalArgumentException();
        }
    }
}
