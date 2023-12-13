package baseball.util.exception;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException>{
    INVALID_INPUT("잘못된 입력입니다.");

    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = ERROR_PREFIX + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
