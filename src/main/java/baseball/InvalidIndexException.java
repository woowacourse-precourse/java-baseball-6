package baseball;

public class InvalidIndexException extends IllegalArgumentException {

    private static final String MESSAGE = "유효하지 않은 인덱스 입니다.";

    public InvalidIndexException() {
        super(MESSAGE);
    }
}
