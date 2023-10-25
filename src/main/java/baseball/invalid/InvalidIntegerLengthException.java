package baseball.invalid;


public class InvalidIntegerLengthException extends IllegalArgumentException {

    private static String INVALID_INTEGER_LENGTH_MESSAGE = "3자리의 수를 입력해야 합니다.";

    public InvalidIntegerLengthException() {
        super(INVALID_INTEGER_LENGTH_MESSAGE);
    }
}