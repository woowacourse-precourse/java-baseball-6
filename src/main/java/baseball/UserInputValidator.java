package baseball;

import java.util.List;
import java.util.Set;

public class UserInputValidator {

    static void validateLength(String string) {
        if (string.length() != Constants.MAX_DIGITS) {
            throw new IllegalArgumentException();
        }
    }

    static void validateNonzeroDigit(int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException();
        }
    }

    static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = Set.copyOf(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }
}
