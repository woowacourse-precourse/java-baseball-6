package baseball.exception;

public class RetryInputException extends IllegalArgumentException {

    public static String ERROR_MEESSAGE = "재시작 선택 시 1이나 2만을 입력해주세요";

    public RetryInputException() {
        super(ERROR_MEESSAGE);
    }
}
