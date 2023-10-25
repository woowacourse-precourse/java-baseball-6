package baseball.exception;

public class InvalidBallCountException extends IllegalArgumentException {

    private static final String errorFormat = "입력 문자의 개수가 올바르지 않습니다. (입력된 문자 수 : %d)";

    public InvalidBallCountException(int ballCount) {
        super(String.format(errorFormat, ballCount));
    }
}
