package baseball.util.exception;

public class duplicateNumberException extends IllegalArgumentException {
    private static final String DUPLICATED_NUMBER = "입력 숫자 중 중복된 숫자가 존재합니다.";

    public duplicateNumberException() {
        super(DUPLICATED_NUMBER);
    }
}
