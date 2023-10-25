package baseball.validation;

import baseball.util.ExceptionUtil;
import baseball.util.IntegerUtil;

public class IntegerValidator {
    private static final String INVALID_INTEGER_MESSAGE = "이 값은 정수로 변환할 수 없습니다.";

    public static void validateInteger(String string) {
        if (!IntegerUtil.isInteger(string)) {
            ExceptionUtil.throwInvalidValueException(INVALID_INTEGER_MESSAGE);
        }
    }
}
