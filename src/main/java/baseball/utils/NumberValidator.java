package baseball.utils;

import baseball.domain.BaseballMessageConst;
import java.util.HashSet;
import java.util.List;

public class NumberValidator {
    public static void isValid(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(BaseballMessageConst.NOT_BALL_SIZE_THREE);
        }
        HashSet<Integer> hashSet = new HashSet<>(numbers);

        if (numbers.size() != hashSet.size()) {
            throw new IllegalArgumentException(BaseballMessageConst.EXIST_BALL);
        }
    }
}
