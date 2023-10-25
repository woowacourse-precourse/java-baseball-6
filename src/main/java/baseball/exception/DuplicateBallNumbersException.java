package baseball.exception;

public final class DuplicateBallNumbersException extends IllegalArgumentException {

    public static final String DUPLICATE_BALL_NUMBERS_EXCEPTION = "BallNumbers에 중복 숫자가 존재하면 안 됩니다.";

    public DuplicateBallNumbersException() {
        super(DUPLICATE_BALL_NUMBERS_EXCEPTION);
    }
}
