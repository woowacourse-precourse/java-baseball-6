package baseball.exception;

public final class InvalidTripleSizeException extends IllegalArgumentException {
    public static final String INVALID_TRIPLE_SIZE_MESSAGE = "Triple은 반드시 3개의 요소로 이루어져야 합니다.";

    public InvalidTripleSizeException() {
        super(INVALID_TRIPLE_SIZE_MESSAGE);
    }
}
