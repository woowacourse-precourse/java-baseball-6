package exception;

public class InvalidBaseBallNumberException extends IllegalArgumentException{
    private static final String INVALID_BASEBALL_NUMBER_MESSAGE = "1부터 9 사이의 숫자만 입력할 수 있습니다";
    public InvalidBaseBallNumberException() {
        super(INVALID_BASEBALL_NUMBER_MESSAGE);
    }
}
