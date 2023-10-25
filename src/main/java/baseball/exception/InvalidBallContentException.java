package baseball.exception;

public class InvalidBallContentException extends IllegalArgumentException {

    private static final String errorFormant = "1과 9 사이 숫자만 입력할 수 있습니다. (올바르지 않은 입력 : %c)";

    public InvalidBallContentException(char invalidInput) {
        super(String.format(errorFormant, invalidInput));
    }
}
