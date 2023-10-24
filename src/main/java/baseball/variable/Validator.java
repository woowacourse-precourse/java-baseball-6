package baseball.variable;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String NOT_THREE = "세 자리 숫자가 아닙니다.";
    private static final String INCLUDE_ZERO = "1 ~ 9 사이의 값을 입력해주세요. 0은 입력할 수 없습니다.";
    private static final String DUPLICATE = "중복된 숫자는 입력할 수 없습니다.";

    public void isValid(List<Integer> number) {
        if (!isThreeNumbers(number)) {
            throw new IllegalArgumentException(NOT_THREE);
        }
        if (isZeroInclude(number)) {
            throw new IllegalArgumentException(INCLUDE_ZERO);
        }
        if (isDuplicate(number)) {
            throw new IllegalArgumentException(DUPLICATE);
        }
    }

    private boolean isThreeNumbers(List<Integer> number) {
        return number.size() <= 3;
    }

    private boolean isZeroInclude(List<Integer> number) {
        return number.contains(0);
    }

    private boolean isDuplicate(List<Integer> number) {
        Set<Integer> numSet = new HashSet<>(number);
        return numSet.size() != number.size();
    }
}
