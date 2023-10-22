package baseball.variable;

import java.util.List;

public class Validator {
    private static final String NOT_THREE = "세 자리 숫자가 아닙니다.";
    private static final String INCLUE_ZERO = "1 ~ 9 사이의 값을 입력해주세요. 0은 입력할 수 없습니다.";

    public void isValid(List number) {
        if (!isThreeNumbers(number)) {
            throw new IllegalArgumentException(NOT_THREE);
        }
        if (isZeroInclue(number)) {
            throw new IllegalArgumentException(INCLUE_ZERO);
        }
    }

    private boolean isThreeNumbers(List number) {
        return number.size() <= 3;
    }

    private boolean isZeroInclue(List number) {
        return number.contains(0);
    }

    // 숫자가 세 자리가 아닌 경우
    // 숫자에 0이 포함된 경우
    // 입력 문자가 중복인 경우
}
