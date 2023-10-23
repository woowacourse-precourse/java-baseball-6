package baseball.exception.number;

public class NumberOutOfRangeException extends IllegalArgumentException {
    private static final String OUT_OF_RANGE_MESSAGE = "1~9 사이의 값만 입력하여야 합니다.";

    public NumberOutOfRangeException() {
        super(OUT_OF_RANGE_MESSAGE);
    }
}
