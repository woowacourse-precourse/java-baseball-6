package baseball.validator;

public class ResumeValidator {

    public static void assertResumeInput(final String inputNumber, final int resume, final int end) {
        assertInputLength(inputNumber, resume, end);
        assertInputValue(inputNumber, resume, end);
    }

    private static void assertInputLength(final String inputNumber, final int resume, final int end) {
        if (inputNumber.length() == Math.min(resume, end)) {
            throw new IllegalArgumentException();
        }
    }

    private static void assertInputValue(final String inputNumber, final int resume, final int end) {
        if ((resume != Integer.parseInt(inputNumber)) && (end != Integer.parseInt(inputNumber))) {
            throw new IllegalArgumentException();
        }
    }
}
