package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public static int[] validateInput(String input) {
        validateInputLength(input);
        int[] guess = convertInputToIntegerArray(input);
        validateInputRange(guess);
        validateInputForDuplicates(guess);
        return guess;
    }

    private static void validateInputLength(String input) {
        if (input.length() != Constants.NUMBER_COUNT) {
            throw new IllegalArgumentException("입력은 반드시 세 자리여야 합니다.");
        }
    }

    private static int[] convertInputToIntegerArray(String input) {
        int[] guess = new int[Constants.NUMBER_COUNT];
        for (int i = 0; i < Constants.NUMBER_COUNT; i++) {
            char c = input.charAt(i);
            guess[i] = Character.getNumericValue(c);
        }
        return guess;
    }

    private static void validateInputRange(int[] guess) {
        for (int num : guess) {
            if (num < Constants.MIN_NUMBER || num > Constants.MAX_NUMBER) {
                throw new IllegalArgumentException("입력은 1에서 9 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateInputForDuplicates(int[] guess) {
        Set<Integer> set = new HashSet<>();
        for (int number : guess) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
            }
        }
    }
}
