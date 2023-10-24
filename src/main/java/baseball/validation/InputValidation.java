package baseball.validation;

import static baseball.constant.Constants.INPUT_MAX_SIZE;
import static baseball.constant.Constants.INPUT_NUM_MAX;
import static baseball.constant.Constants.INPUT_NUM_MIN;
import static baseball.constant.Constants.INPUT_RESTART;
import static baseball.constant.Constants.INPUT_STOP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class InputValidation {

    public static void validExpectedNums(List<Integer> expectedNums) {
        if (!isSize(expectedNums) || !isInRange(expectedNums) || isDuplicate(expectedNums)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validRestartInput(int input) {
        if (input != INPUT_RESTART && input != INPUT_STOP) {
            throw new IllegalArgumentException();
        }
    }

    private static Boolean isSize(List<Integer> target) {
        return target.size() == INPUT_MAX_SIZE;
    }

    private static Boolean isInRange(List<Integer> target) {
        int count = (int) target.stream()
                .filter(t -> t < INPUT_NUM_MIN || t > INPUT_NUM_MAX)
                .count();
        if (count != 0) {
            return false;
        }
        return true;
    }

    private static Boolean isDuplicate(List<Integer> target) {
        Set<Integer> targetSet = new HashSet<>(target);
        return targetSet.size() != INPUT_MAX_SIZE;
    }
}
