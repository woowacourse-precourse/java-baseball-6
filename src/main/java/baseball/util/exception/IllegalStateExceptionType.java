package baseball.util.exception;

public enum IllegalStateExceptionType implements ExceptionType<IllegalStateException>{
    DUPLICATE_INPUT("중복된 값이 입력되었습니다.");

    private final String message;

    IllegalStateExceptionType(String message) {
        this.message = ERROR_PREFIX + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public IllegalStateException getException() {
        return new IllegalStateException(getMessage());
    }
}
