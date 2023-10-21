package baseball.validation;

import baseball.utils.Constant;
import java.util.List;

public class NumberValidation {
    public static void validateInput(List<Integer> number) {
        validateInputLength(number);
        validateInputDigit(number);
        if (validateInputDuplicated(number)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputLength(List<Integer> number) {
        if (Constant.LENGTH != number.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputDigit(List<Integer> number) {
        boolean checkDigit = number.stream()
            .allMatch(n -> Constant.MIN_NUMBER <= n && n <= Constant.MAX_NUMBER);
        if (!checkDigit) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean validateInputDuplicated(List<Integer> number) {
        return Constant.LENGTH != number.stream().distinct().count();
    }
}
