package baseball.handler;

public enum ErrorHandler {

    INVALID_COUNT("3개의 숫자만 입력해야 합니다."),
    INVALID_RANGE("1~9 사이의 숫자만 입력 가능합니다."),
    DUPLICATE_NUMBER("입력한 값은 중복될 수 없습니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        errorMessage = "[ERROR] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
