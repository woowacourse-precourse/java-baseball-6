package baseball.domain.utils;

import java.util.HashSet;
import java.util.Set;

public enum InputRange {

    MIN_INPUT_RANGE(0),
    START_RANDOM_RANGE(1),
    END_RANDOM_RANGE(9),
    MAX_INPUT_RANGE(3);

    private final int value;

    InputRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void validate(String input) {
        Set<Character> uniqueDigits = new HashSet<>();
        validateRange(input, uniqueDigits);
        validateSize(uniqueDigits);
    }

    private static void validateSize(Set<Character> uniqueDigits) {
        if (uniqueDigits.size() != MAX_INPUT_RANGE.value) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(String input, Set<Character> uniqueDigits) {
        for (char digit : input.toCharArray()) {
            if (!Character.isDigit(digit) || Character.getNumericValue(digit) == 0) {
                throw new IllegalArgumentException();
            }
            uniqueDigits.add(digit);
        }
    }
}
