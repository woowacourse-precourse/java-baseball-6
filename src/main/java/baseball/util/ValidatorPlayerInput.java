package baseball.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.view.ErrorMessage.*;

public class ValidatorPlayerInput {
    private static final int NUMBER_SIZE = 3;

    public static void validateNumberSizeAndDuplicate(List<Integer> baseballNumber) {
        if (baseballNumber.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_LENGTH.getMessage());
        }

        Set<Integer> uniqueDigits = new HashSet<>(baseballNumber);
        if (uniqueDigits.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void checkResumeInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(INVALID_GAME_KEEP_GOING_INPUT.getMessage());
        }
    }
}
