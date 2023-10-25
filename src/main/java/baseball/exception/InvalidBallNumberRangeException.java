package baseball.exception;

public final class InvalidBallNumberRangeException extends IllegalArgumentException {
    public static final String INVALID_BALL_NUMBER_RANGE_MESSAGE = "BallNumbers는 1~9 사이의 3자리 수여야 합니다.";

    public InvalidBallNumberRangeException() {
        super(INVALID_BALL_NUMBER_RANGE_MESSAGE);
    }
}
