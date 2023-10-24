package baseball.controller;

import baseball.common.Command;
import baseball.common.Size;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    List<Integer> checkOutOfRange(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (isNotInRange(input.charAt(i))) {
                throw new IllegalArgumentException();
            }
            result.add(Character.getNumericValue(input.charAt(i)));
        }
        return result;
    }

    List<Integer> checkBall(String input) {
        if (input.length() != Size.NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }
        return checkOutOfRange(input);
    }

    String checkCommand(String input) {
        if (input.equals(Command.RESTART.getKey()) || input.equals(Command.QUIT.getKey())) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    private boolean isNotInRange(char number) {
        return !Size.isInRange(Character.getNumericValue(number));
    }
}
