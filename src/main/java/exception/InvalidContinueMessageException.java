package exception;

public class InvalidContinueMessageException extends IllegalArgumentException {
    private static final String INVALID_CONTINUE_MESSAGE = "1 또는 2를 입력해야 합니다";
    public InvalidContinueMessageException() {
        super(INVALID_CONTINUE_MESSAGE);
    }
}
