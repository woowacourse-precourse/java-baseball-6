package baseball.domain;

import java.util.List;

public class GameNumber {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    private final List<Integer> numbers;

    public GameNumber(String input) {
        validate(input);
        this.numbers = null;
    }

    private void validate(String input) {
        validateLength(input);
    }

    private void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
