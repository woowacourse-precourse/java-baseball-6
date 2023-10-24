package baseball.validation;

public enum ErrorMessage {
    INVALID_SIZE("개의 숫자를 입력해야 합니다."),
    INVALID_TYPE("숫자만 입력해야 합니다."),
    INVALID_RANGE("1에서 9까지의 숫자만 입력 가능합니다."),
    NUMBER_DUPLICATE("같은 숫자는 중복해서 입력할 수 없습니다."),
    INVALID_VALUE("1, 2 중 하나를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
