package baseball.validation;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    private static final int INPUT_LENGTH = 3;
    private static final int RESTART_INPUT_LENGTH = 1;
    public static void valiInputNumber(String input) {
        if (isNumber(input) && isLengthThree(input) && isNotDuplicated(input) && isNotContainZero(input)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void valiRestartInput(String restartInput) {
        if (isNumber(restartInput) && isLengthOne(restartInput) && isOneOrTwo(restartInput)) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private static boolean isLengthThree(String input) {
        if (input.length() == INPUT_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean isNotDuplicated(String input) {
        List<Character> numbers = new ArrayList<>();
        for (int i = 0; i < INPUT_LENGTH; i++) {
            numbers.add(input.charAt(i));
        }
        List<Character> newNumbers = numbers.stream().distinct().toList();
        if (newNumbers.size() == INPUT_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean isNotContainZero(String input) {
        if (!input.contains("0")) {
            return true;
        }
        return false;
    }

    private static boolean isLengthOne(String restartInput) {
        if (restartInput.length() == RESTART_INPUT_LENGTH) {
            return true;
        }
        return false;
    }

    private static boolean isOneOrTwo(String restartInput) {
        int restartNumber = Integer.parseInt(restartInput);
        if ((restartNumber == 1) || (restartNumber == 2)){
            return true;
        }
        return false;
    }
}
