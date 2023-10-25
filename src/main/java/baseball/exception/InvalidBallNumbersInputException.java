package baseball.exception;

public final class InvalidBallNumbersInputException extends IllegalArgumentException {

    public static final String INVALID_NUMBERS_INPUT_MESSAGE = "유효하지 않은 입력입니다.\n반드시 3자리 숫자로 입력하셔야 합니다.";

    public InvalidBallNumbersInputException() {
        super(INVALID_NUMBERS_INPUT_MESSAGE);
    }
}
