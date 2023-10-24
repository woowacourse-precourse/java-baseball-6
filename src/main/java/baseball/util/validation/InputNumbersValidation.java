package baseball.util.validation;

import baseball.util.Messages;
import java.util.ArrayList;

public class InputNumbersValidation {
    public static void validateAll(ArrayList<Integer> input) {
        validateLength(input);
        validateRange(input);
        validateDuplication(input);
    }

    private static void validateLength(ArrayList<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException(Messages.INVALID_LENGTH);
        }
    }

    private static void validateRange(ArrayList<Integer> input) {
        for (int number : input) {
            if (number < 1 || number > 9) {
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

