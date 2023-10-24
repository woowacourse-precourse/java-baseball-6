package baseball.util.exception;

public class invalidInputException extends IllegalArgumentException {
    private static final String INVAILD_INPUT = "올바르지 않은 입력입니다.";

    public invalidInputException() {
        super(INVAILD_INPUT);
    }
}
