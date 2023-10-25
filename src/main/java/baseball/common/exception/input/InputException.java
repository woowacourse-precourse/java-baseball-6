package baseball.common.exception.input;

public class InputException extends IllegalArgumentException {
    private final InputErrorCode errorCode;

    public InputException(InputErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
