package baseball.view;

import java.util.List;

public final class InputValidator {

    private static final char MIN_NUMBER_SIZE = '1';
    private static final char MAX_NUMBER_SIZE = '9';

    public void validateIsNumeric(String input) {
        boolean isNumeric = input.chars()
                .allMatch(number -> MIN_NUMBER_SIZE <= number && number <= MAX_NUMBER_SIZE);

        if (!isNumeric) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCommand(List<Integer> validNumber, int number) {
        boolean isMatch = validNumber.stream().anyMatch(valid -> valid == number);

        if (!isMatch) {
            throw new IllegalArgumentException();
        }
    }
}