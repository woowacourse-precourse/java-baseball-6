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

    public static Boolean validExpectedNums(List<Integer> expectedNums) {
        return isSizeThree(expectedNums) && isInRange(expectedNums) && !isDuplicate(expectedNums);
    }

    public static Boolean isRestartInput(int input) {
        return input == INPUT_RESTART || input == INPUT_STOP;
    }

    private static Boolean isSizeThree(List<Integer> target) {
        return target.size() == INPUT_MAX_SIZE;
    }

    private static Boolean isInRange(List<Integer> target) {
        for (int t : target) {
            if (t < INPUT_NUM_MIN || t > INPUT_NUM_MAX) {
                return false;
            }
        }
        return true;
    }

    private static Boolean isDuplicate(List<Integer> target) {
        Set<Integer> targetSet = new HashSet<>(target);
        return targetSet.size() != INPUT_MAX_SIZE;
    }
}
