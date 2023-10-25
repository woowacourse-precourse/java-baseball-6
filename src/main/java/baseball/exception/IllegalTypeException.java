package baseball.exception;

public class IllegalTypeException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "입력값은 반드시 숫자이어야 합니다. 프로그램을 종료합니다.";

    public IllegalTypeException() {
        super(DEFAULT_MESSAGE);
    }
}
