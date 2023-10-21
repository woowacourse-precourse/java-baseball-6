package baseball.view;

import baseball.util.Err;
import java.util.Arrays;

public class InputValidator {
    private static final char START_INCLUSIVE = '1';
    private static final char END_INCLUSIVE = '9';

    public static void validateInputLength(String input, int inputSize) {
        if (input.length() != inputSize) {
            throw new IllegalArgumentException(Err.ERROR_NOT_THREE_SIZE_MESSAGE.getMessage());
        }
    }

    public static void validateInputScope(String input, int inputSize) {
        for (int i = 0; i < inputSize; i++) {
            if (input.charAt(i) < START_INCLUSIVE || input.charAt(i) > END_INCLUSIVE) {
                throw new IllegalArgumentException(Err.ERROR_INPUT_SCOPE_MESSAGE.getMessage());
            }
        }
    }

    public static void validateInputDuplicated(String input) {
        long uniqueCount = Arrays.stream(input.split(""))
                .distinct()
                .count();

        if (uniqueCount != input.length()) {
            throw new IllegalArgumentException(Err.ERROR_NUMBERS_DUPLICATION_MESSAGE.getMessage());
        }
    }
}
