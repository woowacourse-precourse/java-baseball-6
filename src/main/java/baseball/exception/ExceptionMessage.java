package baseball.exception;

public class ExceptionMessage {
    public static final String EXCEPTION_MESSAGE_INVALID_LENGTH = "길이 %d으로 입력해야 합니다. 현재 길이: %d";
    public static final String EXCEPTION_MESSAGE_NON_UNIQUE = "%s에 중복된 숫자가 존재합니다.";
    public static final String EXCEPTION_MESSAGE_INVALID_RANGE = "%d은 범위를 벗어난 숫자입니다.";
    public static final String EXCEPTION_MESSAGE_NON_NUMERIC = "%s는 숫자가 아닌 문자입니다.";

    private ExceptionMessage() {
    }
}
