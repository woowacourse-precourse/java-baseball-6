package baseball.validation;

import java.util.Arrays;

import static baseball.constant.Constant.*;

public class NumberValidation {

    public void validationAll(int[] input) {
        validateDuplicate(input);
        validateRangeAndType(input);
        validateLength(input);
    }

    private static void validateDuplicate(int[] input) {
        if (!(input.length == Arrays.stream(input).distinct().count())) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해주세요.");
        }
    }

    private void validateLength(int[] input) {
        if (!(input.length == NUMBER_LENGTH)) {
            throw new IllegalArgumentException("숫자 3개를 입력해주세요.");
        }
    }

    private void validateRangeAndType(int[] input) {
        if (!(input.length == Arrays.stream(input).filter(i -> i >= MIN_NUMBER && i <= MAX_NUMBER).count())) {
            throw new IllegalArgumentException("1과 9 사이의 숫자를 입력해주세요.");
        }
    }

    public static boolean validateIsInArray(int[] computerNumber, int num) {
        return Arrays.stream(computerNumber).anyMatch(array -> array == num);
    }

    public static boolean validateComputerDuplicate(int[] input) {
        return input.length == Arrays.stream(input).distinct().count();
    }

    public static void validateGameStatus(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
