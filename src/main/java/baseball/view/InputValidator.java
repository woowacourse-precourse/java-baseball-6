package baseball.view;

import baseball.domain.CommandType;

import java.util.Arrays;

public final class InputValidator {
    public void validateIsNumeric(String input) {
        boolean isNumeric = input.chars()
                .allMatch(number -> '0' <= number && number <= '9');

        if (!isNumeric) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCommand(int number) {
        boolean isMatch = Arrays.stream(CommandType.values())
                .anyMatch(type -> type.getNumber() == number);

        if (!isMatch) {
            throw new IllegalArgumentException();
        }
    }
}
