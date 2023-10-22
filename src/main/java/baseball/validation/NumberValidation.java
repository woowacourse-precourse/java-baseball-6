package baseball.validation;

import java.util.Arrays;

public class NumberValidation {
    public void validationAll(int[] input) {
        validateDuplicate(input);
        validateRangeAndType(input);
    }

    public static void validateDuplicate(int[] input) {
        if (!(input.length == Arrays.stream(input).distinct().count())) {
            throw new IllegalArgumentException("숫자의 형식이 올바르지 않습니다.");
        }
    }

    private void validateRangeAndType(int[] input) {
        if (!(input.length == Arrays.stream(input).filter(i -> i >= 1 && i <= 9).count())) {
            throw new IllegalArgumentException("숫자의 형식이 올바르지 않습니다.");
        }
    }

    public static void validateGameStatus(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("숫자의 형식이 올바르지 않습니다.");
        }
    }
}
