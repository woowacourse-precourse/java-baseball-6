package baseball.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.Constants.*;

public class InputValidation {

    public Boolean checkSize (List<Integer> target) {
        return target.size() == INPUT_MAX_SIZE;
    }

    public Boolean checkRange (List<Integer> target) {
        for (int t : target) {
            if (t < INPUT_NUM_MIN || t > INPUT_NUM_MAX) return false;
        }
        return true;
    }

    public Boolean checkDuplicate(List<Integer> target) {
        Set<Integer> targetSet = target.stream().collect(Collectors.toSet());
        return targetSet.size() == INPUT_MAX_SIZE;
    }

    public Boolean checkRestart (int input) {
        return input == INPUT_RESTART || input == INPUT_STOP;
    }
}
