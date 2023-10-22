package baseball.validation;

import baseball.utils.Constant;
import baseball.utils.ErrorMessage;
import java.util.List;

public class InputValidation {
    public static void validateInput(List<Integer> number) {
        validateInputLength(number);
        validateInputDigit(number);
        if (validateInputDuplicated(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_INPUT);
        }
    }

    public static void validateInputLength(List<Integer> number) {
        if (Constant.LENGTH != number.size()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_LENGTH);
        }
    }

    public static void validateInputDigit(List<Integer> number) {
        boolean checkDigit = number.stream()
            .allMatch(n -> Constant.MIN_NUMBER <= n && n <= Constant.MAX_NUMBER);
        if (!checkDigit) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT_TYPE);
        }
    }

    public static boolean validateInputDuplicated(List<Integer> number) {
        return Constant.LENGTH != number.stream().distinct().count();
    }

    public static boolean validateInputRestartOrExit(String input) {
        if (input.equals(Constant.GAME_RESTART)) {
            return true;
        }
        if (input.equals(Constant.GAME_EXIT)) {
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.WRONG_INPUT);
    }
}
