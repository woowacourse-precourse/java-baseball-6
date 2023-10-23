package baseball.domain;

public class Errors {
    private static final String MSG_EXCEPTION_INVALID_INPUT = "올바르지 않은 입력값입니다.";
    private static final String MSG_EXCEPTION_INVALID_RANGE = "숫자는 올바른 범위여야 합니다.";

    public static String getInvalidInputMessage() {
        return MSG_EXCEPTION_INVALID_INPUT;
    }

    public static String getInvalidRangeMessage() {
        return MSG_EXCEPTION_INVALID_RANGE;
    }
}
