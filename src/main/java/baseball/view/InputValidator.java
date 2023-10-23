package baseball.view;

import java.util.List;

public final class InputValidator {
    public void validateIsNumeric(String input) {
        boolean isNumeric = input.chars()
                .allMatch(number -> '0' <= number && number <= '9');

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