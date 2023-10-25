package exception;

public class InvalidDuplicatedBaseBallException extends IllegalArgumentException{
    private static final String INVALID_DUPLICATED_BASEBALL_MESSAGE = "서로 다른 정수 세 개를 입력해야 합니다";
    public InvalidDuplicatedBaseBallException() {
        super(INVALID_DUPLICATED_BASEBALL_MESSAGE);
    }
}
