package baseball.validation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.Constants.*;

public final class InputValidation {

    public static Boolean isSizeThree(List<Integer> target) {
        return target.size() == INPUT_MAX_SIZE;
    }

    public static Boolean isInRange(List<Integer> target) {
        for (int t : target) {
            if (t < INPUT_NUM_MIN || t > INPUT_NUM_MAX) return false;
        }
        return true;
    }

    public static Boolean isDuplicate(List<Integer> target) {
        Set<Integer> targetSet = target.stream().collect(Collectors.toSet());
        return targetSet.size() != INPUT_MAX_SIZE;
    }

    public static Boolean isRestartInput (int input) {
        return input == INPUT_RESTART || input == INPUT_STOP;
    }
}
