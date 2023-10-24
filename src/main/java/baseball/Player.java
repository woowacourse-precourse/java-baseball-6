package baseball;

import static baseball.Constant.DUPLICATE_INPUT_MESSAGE;
import static baseball.Constant.INVALID_INPUT_MESSAGE;
import static baseball.Constant.LENGTH_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> makeGuess(String input) {
        List<Integer> guess = new ArrayList<>();
        validateInput(input, guess);

        return guess;
    }

    private void validateInput(String input, List<Integer> guess) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
        for (int i = 0; i < input.length(); i++) {
            if (!isValid(input.charAt(i))) {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
        for (int i = 0; i < input.length(); i++) {
            if (guess.contains(input.charAt(i) - '0')) {
                throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
            }
            guess.add(input.charAt(i) - '0');
        }
    }

    public boolean isValid(char c) {
        return c >= '1' && c <= '9';
    }
}
