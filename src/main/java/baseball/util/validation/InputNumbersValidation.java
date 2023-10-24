package baseball.util.validation;

import static baseball.util.Constants.*;

import java.util.ArrayList;
import baseball.util.Messages;

public class InputNumbersValidation {
    public static void validateAll(ArrayList<Integer> input) {
        validateLength(input);
        validateRange(input);
        validateDuplication(input);
    }

    private static void validateLength(ArrayList<Integer> input) {
        if (input.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(Messages.INVALID_LENGTH);
        }
    }

    private static void validateRange(ArrayList<Integer> input) {
        for (int number : input) {
            if (number < NUMBER_MIN_RANGE || number > NUMBER_MAX_RANGE) {
                throw new IllegalArgumentException(Messages.INVALID_TYPE_AND_RANGE);
            }
        }
    }

    private static void validateDuplication(ArrayList<Integer> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                if (input.get(i).equals(input.get(j))) {
                    throw new IllegalArgumentException(Messages.INVALID_DUPLICATION);
                }
            }
        }
    }
}

