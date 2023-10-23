package view.processing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utils.GameConstant.BASEBALL_GAME_NUMBER_LENGTH;
import static utils.GameErrorMessage.INVALID_LENGTH_MESSAGE;
import static utils.GameErrorMessage.NULL_INPUT_MESSAGE;

public class Validator {
    public boolean isBaseballNumber(String input) {
        Objects.requireNonNull(input, NULL_INPUT_MESSAGE);

        if (input.length() != BASEBALL_GAME_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }

        List<Integer> numbers = new ArrayList<>();

        for (char c : input.toCharArray()) {
            int number = Character.getNumericValue(c);
            if (numbers.contains(number)) {
                return false;
            }
            numbers.add(number);
        }
        return true;
    }
}
