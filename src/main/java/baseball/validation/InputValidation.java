package baseball.validation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.Constants.*;

public final class InputValidation {

    public static Boolean validExpectedNums(List<Integer> expectedNums){
        return isSizeThree(expectedNums) && isInRange(expectedNums) && !isDuplicate(expectedNums);
    }

    public static Boolean isRestartInput (int input) {
        return input == INPUT_RESTART || input == INPUT_STOP;
    }

    private static Boolean isSizeThree(List<Integer> target) {
        return target.size() == INPUT_MAX_SIZE;
    }

    private static Boolean isInRange(List<Integer> target) {
        for (int t : target) {
            if (t < INPUT_NUM_MIN || t > INPUT_NUM_MAX) return false;
        }
        return true;
    }

    private static Boolean isDuplicate(List<Integer> target) {
        Set<Integer> targetSet = target.stream().collect(Collectors.toSet());
        return targetSet.size() != INPUT_MAX_SIZE;
    }
}
