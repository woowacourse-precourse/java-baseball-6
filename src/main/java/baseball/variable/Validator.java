package baseball.variable;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    private static final String NOT_THREE = "세 자리 숫자가 아닙니다.";
    private static final String INCLUE_ZERO = "1 ~ 9 사이의 값을 입력해주세요. 0은 입력할 수 없습니다.";
    private static final String DUPLICATE = "중복된 숫자는 입력할 수 없습니다.";

    public void isValid(List number) {
        if (!isThreeNumbers(number)) {
            throw new IllegalArgumentException(NOT_THREE);
        }
        if (isZeroInclue(number)) {
            throw new IllegalArgumentException(INCLUE_ZERO);
        }
        if (isDuplicate(number)) {
            throw new IllegalArgumentException(DUPLICATE);
        }
    }

    private boolean isThreeNumbers(List number) {
        return number.size() <= 3;
    }

    private boolean isZeroInclue(List number) {
        return number.contains(0);
    }

    private boolean isDuplicate(List number) {
        Set<Integer> numSet = new HashSet<>(number);

        return numSet.size() != number.size();
    }

    // 숫자가 세 자리가 아닌 경우
    // 숫자에 0이 포함된 경우
    // 입력 문자가 중복인 경우
}
