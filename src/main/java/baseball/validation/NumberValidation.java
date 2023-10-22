package baseball.validation;

import static baseball.constant.Constant.NUMBER_LENGTH;

import java.util.Arrays;

public class NumberValidation {

    public void validationAll(int[] input) {
        validateDuplicate(input);
        validateRangeAndType(input);
        validateLength(input);
    }

    public static void validateDuplicate(int[] input) {
        if (!(input.length == Arrays.stream(input).distinct().count())) {
            throw new IllegalArgumentException("숫자의 형식이 올바르지 않습니다.");
        }
    }

    private void validateLength(int[] input) {
        if (!(input.length == NUMBER_LENGTH)) {
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

    public static boolean validateComputerDuplicate(int[] input) {
        return input.length == Arrays.stream(input).distinct().count();
    }

    public static boolean isInArray(int[] computerNumber, int num) {
        return Arrays.stream(computerNumber).anyMatch(array -> array == num);
    }
}
