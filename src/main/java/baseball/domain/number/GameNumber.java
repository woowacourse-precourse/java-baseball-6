package baseball.domain.number;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.service.NumberGenerator.NUMBER_COUNT;
import static baseball.util.ErrorMessage.*;

public class GameNumber {

    public GameNumber(List<Integer> number) {
        checkNumber(number);
    }

    private void checkNumber(List<Integer> number) {
        checkLength(number);
        checkDuplicate(number);
        checkZero(number);
        checkNegative(number);
    }

    private void checkLength(List<Integer> number) {
        if (number.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(LENGTH_ERROR);
        }
    }

    private void checkDuplicate(List<Integer> number) {
        Set<Integer> set = new HashSet<>(number);
        if (set.size() != number.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
    }

    private void checkZero(List<Integer> number) {
        if (number.contains(0)) {
            throw new IllegalArgumentException(ZERO_ERROR);
        }
    }

    private void checkNegative(List<Integer> number) {
        for (Integer i : number) {
            if (isNegative(i)) {
                throw new IllegalArgumentException(NEGATIVE_ERROR);
            }
        }
    }

    private static boolean isNegative(Integer i) {
        return i < 0;
    }
}
