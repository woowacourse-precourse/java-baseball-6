package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int NUMBER_COUNT = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static List<Integer> validateInput(String input) {
        validateInputLength(input);
        List<Integer> guess = convertInputToIntegerList(input);
        validateInputRange(guess);
        validateInputForDuplicates(guess);
        return guess;
    }

    private static void validateInputLength(String input) {
        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException("입력은 반드시 세 자리여야 합니다.");
        }
    }

    private static List<Integer> convertInputToIntegerList(String input) {
        List<Integer> guess = new ArrayList<>();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            char c = input.charAt(i);
            guess.add(Character.getNumericValue(c));
        }
        return guess;
    }

    private static void validateInputRange(List<Integer> guess) {
        for (int num : guess) {
            if (num < MIN_NUMBER || num > MAX_NUMBER) {
                throw new IllegalArgumentException("입력은 1에서 9 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateInputForDuplicates(List<Integer> guess) {
        Set<Integer> set = new HashSet<>();
        for (int number : guess) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
            }
        }
    }

}
