package baseball.io;

import baseball.domain.Constants;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateLength(final String string) {
        if (string.length() != Constants.MAX_DIGITS) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNonzeroDigit(final int digit) {
        if (digit < 1 || digit > 9) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = Set.copyOf(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
