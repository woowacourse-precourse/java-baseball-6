package baseball.controller;

import baseball.common.Command;
import baseball.common.Size;

public class InputValidator {
    int checkOutOfNumber(int input) {
        if (Size.isInSize(input)) {
            return checkOutOfRange(Integer.toString(input));
        }
        throw new IllegalArgumentException();
    }

    int checkOutOfRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Size.isInRange(Character.getNumericValue(input.charAt(i)))) {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(input);
    }

    int isInteger(String input) {
        try {
            return checkOutOfNumber(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    String checkCommand(String input) {
        if (input.equals(Command.RESTART.getKey()) || input.equals(Command.QUIT.getKey())) {
            return input;
        }
        throw new IllegalArgumentException();
    }
}
