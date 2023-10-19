package baseball.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberValidator {

    public static void assertNumberValue(final String input) {
        if (!isInputValidPositiveNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInputValidPositiveNumber(final String input) {
        return input.matches("^[1-9]+$");
    }

    public static void assertDigitLength(final String inputNumber, final int expectedDigitLength) {
        if (!isStringLengthEqualToExpectedLength(inputNumber, expectedDigitLength)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isStringLengthEqualToExpectedLength(final String input, final int expectedLength) {
        return input.length() == expectedLength;
    }

    public static void assertEachNumberUnique(final String input) {

        if (!isAllNumberUnique(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static Set<char[]> convertInputToSet(final String input) {

        return new HashSet<>(List.of(input.toCharArray()));
    }

    private static boolean isAllNumberUnique(final String inputNumber) {

        return convertInputToSet(inputNumber).size() == inputNumber.length();
    }
}
