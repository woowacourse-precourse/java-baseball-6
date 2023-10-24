package baseball.exception;

import java.util.ArrayList;
import java.util.HashSet;

import static baseball.Config.*;

public class InputException{
    public static void validateInput(String input) {
        checkNumberLength(input);
        isNumeric(input);
        checkInputNumberOverlap(input);
    }

    public static void validateInput(ArrayList<Integer> input) {
        checkNumberLength(input);
        checkInputNumberOverlap(input);
    }

    public static void validateRestartInput(String input) {
        checkRestartNumberLength(input);
        checkRestartNumberType(input);
    }

    public static void validateRestartInput(int input) {
        checkRestartNumberLength(input);
        checkRestartNumberType(input);
    }

    private static void checkNumberLength(String input) {
        if (input.length() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);
        }
    }
    private static void checkNumberLength(ArrayList<Integer> input) {
        if (input.size() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);
        }
    }
    private static void checkRestartNumberLength(String input) {
        if (input.length() != RESTART_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);
        }
    }
    private static void checkRestartNumberLength(int input) {
        if (input / 10 != 0) {
            throw new IllegalArgumentException(RESTART_INPUT_LENGTH_ERROR_MESSAGE);
        }
    }

    private static void checkRestartNumberType(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(RESTART_INPUT_ERROR_MESSAGE);
        }
    }
    private static void checkRestartNumberType(int input) {
        if (!(input == 1 || input == 2)) {
            throw new IllegalArgumentException(RESTART_INPUT_ERROR_MESSAGE);
        }
    }

    private static void checkInputNumberOverlap(String input) {
        char firstChar = input.charAt(0);
        char secondChar = input.charAt(1);
        char thirdChar = input.charAt(2);
        if (firstChar == secondChar || secondChar == thirdChar || firstChar == thirdChar) {
            throw new IllegalArgumentException(INPUT_NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }

    private static void checkInputNumberOverlap(ArrayList<Integer> input) {
        HashSet<Integer> inputNumbers = new HashSet<>(input);
        if (inputNumbers.size() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INPUT_NUMBER_OVERLAP_ERROR_MESSAGE);
        }
    }
    private static void isNumeric(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_NUMERIC_ERROR);
        }
    }
}
