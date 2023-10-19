package baseball.controller;

import baseball.common.Command;
import baseball.common.Size;

public class InputValidator {
    int checkOutOfNumber(int input) {
        if (Integer.toString(input).length() != Size.NUMBER.getValue() && input > 0) {
            throw new IllegalArgumentException();
        }
        return checkOutOfRange(input);
    }

    int checkOutOfRange(int input) {
        String num = Integer.toString(input);
        for (int i = 0; i < num.length(); i++) {
            if (!Size.isBetweenSize(Character.getNumericValue(num.charAt(i)))) {
                throw new IllegalArgumentException();
            }
        }
        return input;
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
