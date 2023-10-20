package baseball.validation;

import baseball.utils.Constant;
import java.util.List;

public class NumberValidation {
    public static boolean isDuplicated(List<Integer> number) {
        return Constant.LENGTH != number.stream().distinct().count();
    }
}
