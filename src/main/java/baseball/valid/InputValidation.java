package baseball.valid;

import static baseball.consts.NumberConst.END_NUMBER;
import static baseball.consts.NumberConst.GAME_END_NUMBER;
import static baseball.consts.NumberConst.GAME_RESTART_NUMBER;
import static baseball.consts.NumberConst.NUMBER_SIZE;
import static baseball.consts.NumberConst.START_NUMBER;

public class InputValidation {

    public static void validateInputNum(String input) {
        validateOnlyNum(input);
        validateAllDifferentNumAndSize(input);
        validateNumRange(input);
    }

    private static void validateOnlyNum(String input) {
        String reg = "^[0-9]*$";
        if (!input.matches(reg)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateAllDifferentNumAndSize(String input) {
        if (input.chars().count() != NUMBER_SIZE || input.chars().distinct().count() != NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNumRange(String input) {
        if (!input.chars().map(letter -> letter - '0').boxed()
                .allMatch(num -> num >= START_NUMBER && num <= END_NUMBER)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRestartNum(String input) {
        if (!input.equals(GAME_RESTART_NUMBER) && !input.equals(GAME_END_NUMBER)) {
            throw new IllegalArgumentException();
        }

    }

}
