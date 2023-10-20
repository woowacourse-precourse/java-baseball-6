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
        if (!isInputValidPositiveNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInputValidPositiveNumber(final String input) {
        return input.matches("^[1-9]+$");
    }

    private static void assertDigitLength(final String inputNumber, final int expectedDigitLength) {
        if (!isStringLengthEqualToExpectedLength(inputNumber, expectedDigitLength)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isStringLengthEqualToExpectedLength(final String input, final int expectedLength) {
        return input.length() == expectedLength;
    }

    private static void assertEachNumberUnique(final String input) {
        if (!isAllNumberUnique(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isAllNumberUnique(final String inputNumber) {
        return convertInputToSet(inputNumber).size() == inputNumber.length();
    }

    private static Set<Character> convertInputToSet(final String input) {
        HashSet<Character> inputSet = new HashSet<>();

        for (char character : input.toCharArray()) {
            inputSet.add(character);
        }

        return inputSet;
    }
}
