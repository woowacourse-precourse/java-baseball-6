package baseball.exception;

public class IllegalDuplicateException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "숫자는 중복을 허용하지 않습니다.";

    public IllegalDuplicateException() {
        super(DEFAULT_MESSAGE);
    }
}
