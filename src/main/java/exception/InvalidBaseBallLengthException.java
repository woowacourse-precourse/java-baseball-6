package exception;

public class InvalidBaseBallLengthException extends IllegalArgumentException {
    private static final String INVALID_BASEBALL_LENGTH_MESSAGE = "3자리의 정수를 입력해야 합니다";
    public InvalidBaseBallLengthException() {
        super(INVALID_BASEBALL_LENGTH_MESSAGE);
    }
}
