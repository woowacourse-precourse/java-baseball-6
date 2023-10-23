package baseball.model;

import java.util.List;

public class GameInput {
    private static final int GAME_INPUT_SIZE = 3;
    private static final String GAME_INPUT_RULE = "[0-9]{" + GAME_INPUT_SIZE + "}";

    private final String input;

    public GameInput(String input) {
        validateInputSize(input);
        validateInputDigit(input);
        validateInputDuplicated(input);
        this.input = input;
    }

    private void validateInputSize(String input) {
        if (input.length() != GAME_INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputDigit(String input) {
        if (!input.matches(GAME_INPUT_RULE)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputDuplicated(String input) {
        long count = input.chars()
                .distinct()
                .count();
        if (count != GAME_INPUT_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> convertInputToUserNumbers() {
        return input.chars()
                .map(c -> c - '0')
                .boxed()
                .toList();
    }
}
