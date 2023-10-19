package baseball.validator;

public class NumberValidator {

    public static void assertDigitLength(final int inputNumber, final int expectedDigitLength) {
        if (!isStringLengthEqualToExpectedLength(numberToString(inputNumber), expectedDigitLength)) {
            throw new IllegalArgumentException();
        }
    }

    private static String numberToString(final int number) {
        return String.valueOf(number);
    }

    private static boolean isStringLengthEqualToExpectedLength(final String input, final int expectedLength) {
        return input.length() == expectedLength;
    }
}
