package baseball.util.validation;

import baseball.util.Messages;

public class InputNumbersValidation {
    private static void validateLength(int[] input) {
        if (input.length != 3) {
            throw new IllegalArgumentException(Messages.INVALID_LENGTH);
        }
    }

    private static void validateRange(int[] input) {
        for (int number : input) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException(Messages.INVALID_TYPE_AND_RANGE);
            }
        }
    }

    private static void validateDuplication(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    throw new IllegalArgumentException(Messages.INVALID_DUPLICATION);
                }
            }
        }
    }
}

