package view.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utils.GameConstant.BASEBALL_GAME_NUMBER_LENGTH;
import static utils.GameErrorMessage.*;

public class Validator {
    public Validator() {
    }

    public void validateBaseballNumber(String input) {
        Objects.requireNonNull(input, NULL_INPUT_MESSAGE);

        if (input.length() != BASEBALL_GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }

        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ERROR_ONLY_NUMBERS_ALLOWED);
            }

            int number = Character.getNumericValue(c);
            if (numbers.contains(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
            }
            numbers.add(number);
        }
    }

    public void totalCountsNotExceedingLimit(int strike, int ball) {
        int total = strike + ball;
        if (total > 3) {
            throw new IllegalArgumentException(EXCEEDING_COUNT_ERROR_MESSAGE);
        }
    }
}
