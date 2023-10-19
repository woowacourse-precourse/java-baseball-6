package baseball.validator;

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
}
