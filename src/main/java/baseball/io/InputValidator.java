package baseball.io;

public class InputValidator {

    private static final char MIN_NUMBER = '0';
    private static final char MAX_NUMBER = '9';

    public void validateNumber(final String input) {
        if (hasNonNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasNonNumeric(final String input) {
        return input.chars().allMatch(this::isNotNumeric);
    }

    private boolean isNotNumeric(final int c) {
        return MIN_NUMBER > c || c > MAX_NUMBER;
    }
}
