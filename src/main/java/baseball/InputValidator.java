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

    /*
     * 세자리인지 판단
     */
    private static void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력은 반드시 세 자리여야 합니다.");
        }
    }

    private static int[] convertInputToIntegerArray(String input) {
        int[] guess = new int[3];
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            guess[i] = Character.getNumericValue(c);
        }
        return guess;
    }

    /*
     * 모두 1 ~ 9 사이 숫자인지 판단
     */
    private static void validateInputRange(int[] guess) {
        for (int num : guess) {
            if (num < 1 || num > 9) {
                throw new IllegalArgumentException("입력은 1에서 9 사이의 숫자여야 합니다.");
            }
        }
    }

    /*
     * 중복 숫자가 있는지 판단
     */
    private static void validateInputForDuplicates(int[] guess) {
        Set<Integer> set = new HashSet<>();
        for (int number : guess) {
            set.add(number);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

}
