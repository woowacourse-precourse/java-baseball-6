package baseball.common.utils;

import baseball.common.config.BaseballMessageConst;
import java.util.HashSet;
import java.util.List;

public class NumberValidator {
    public static void isValid(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(BaseballMessageConst.INVALID_BALL_COUNT_ERROR);
        }
        HashSet<Integer> hashSet = new HashSet<>(numbers);

        if (numbers.size() != hashSet.size()) {
            throw new IllegalArgumentException(BaseballMessageConst.EXIST_BALL_ERROR);
        }
    }
}
