package baseball;

import java.util.HashSet;
import java.util.Set;

public enum InputRange {

    START_INDEX(0),
    START_RANDOM_RANGE(1),
    END_RANDOM_RANGE(9),
    CORRECT_INPUT_RANGE(3);

    private final int value;

    InputRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void inputValidation(String inputString) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : inputString.toCharArray()) {
            if (!Character.isDigit(digit) || Character.getNumericValue(digit) == 0) {
                throw new IllegalArgumentException();
            }
            uniqueDigits.add(digit);
        }

        if (uniqueDigits.size() != InputRange.CORRECT_INPUT_RANGE.getValue()) {
            throw new IllegalArgumentException();
        }
    }
}
