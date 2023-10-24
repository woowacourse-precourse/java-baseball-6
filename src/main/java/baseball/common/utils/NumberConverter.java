package baseball.common.utils;

import baseball.common.config.BaseballMessageConst;
import java.util.ArrayList;
import java.util.List;

public class NumberConverter {
    public static List<Integer> stringToNumber(String value) {
        List<Integer> numbers = new ArrayList<>();
        for (char number : value.toCharArray()) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException(BaseballMessageConst.INVALID_BALL_TYPE);
            }
            numbers.add(number - '0');
        }
        return numbers;
    }
}
