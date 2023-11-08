package refactor.exception;

public class AppException extends IllegalArgumentException {

    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
