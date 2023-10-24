package baseball.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력된 숫자는 3자리여야 합니다.");
        }
    }
    private static void checkNumberLength(ArrayList<Integer> input) {
        if (input.size() != 3) {
            throw new IllegalArgumentException("입력된 숫자는 3자리여야 합니다.");
        }
    }
    private static void checkRestartNumberLength(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("입력된 숫자는 1자리여야 합니다.");
        }
    }
    private static void checkRestartNumberLength(int input) {
        if (input / 10 != 0) {
            throw new IllegalArgumentException("입력된 숫자는 1자리여야 합니다.");
        }
    }

    private static void checkRestartNumberType(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }
    private static void checkRestartNumberType(int input) {
        if (!(input == 1 || input == 2)) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }

    private static void checkInputNumberOverlap(String input) {
        char firstChar = input.charAt(0);
        char secondChar = input.charAt(1);
        char thirdChar = input.charAt(2);
        if (firstChar == secondChar || secondChar == thirdChar || firstChar == thirdChar) {
            throw new IllegalArgumentException("서로 다른 3자리를 입력해주세요");
        }
    }

    private static void checkInputNumberOverlap(ArrayList<Integer> input) {
        HashSet<Integer> inputNumbers = new HashSet<>(input);
        if (inputNumbers.size() != 3) {
            throw new IllegalArgumentException("서로 다른 3자리를 입력해주세요");
        }
    }
    private static void isNumeric(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값은 숫자여야 합니다.");
        }
    }
}
