package baseball.validator;

import baseball.converter.IntegerInputConverter;

public class ResumeValidator {

    public static void assertResumeInput(final String inputNumber, final int resume, final int end) {
        assertInputLength(inputNumber, resume, end);
        assertInputValue(inputNumber, resume, end);
    }

    private static void assertInputLength(final String inputNumber, final int resume, final int end) {
        if (!isInputLengthValid(inputNumber, resume, end)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInputLengthValid(final String input, final int resume, final int end) {
        return input.length() == Math.min(resume, end);
    }

    private static void assertInputValue(final String inputNumber, final int resume, final int end) {
        if (!isInputEqualToNumber(inputNumber, resume) && !isInputEqualToNumber(inputNumber, end)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInputEqualToNumber(final String input, final int number) {
        return input.equals(IntegerInputConverter.toString(number));
    }
}
