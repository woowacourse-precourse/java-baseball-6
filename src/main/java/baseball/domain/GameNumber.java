package baseball.domain;

import java.util.List;

public class GameNumber {
    private static final int NUMBER_LENGTH = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final String ZERO = "0";

    private final List<Integer> numbers;

    public GameNumber(String input) {
        validate(input);
        this.numbers = null;
    }

    private void validate(String input) {
        validateLength(input);
        validateValidNumber(input);
    }

    private void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateValidNumber(String input) {
        isNumber(input);
        isContainingZero(input);
    }

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void isContainingZero(String input) {
        if (input.contains(ZERO)) {
            throw new IllegalArgumentException();
        }
    }
}
