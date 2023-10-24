package baseball;

public class InvalidRetryInputException extends IllegalArgumentException {

    private static final String MESSAGE = "유효하지 않은 재시도 여부 입력입니다.";

    public InvalidRetryInputException() {
        super(MESSAGE);
    }
}
