package baseball.utils;

public enum ExceptionMessage {

    NUMBERS_LENGTH_ERROR("3개의 수를 입력해주세요."),
    DUPLICATE_NUMBER_ERROR("중복된 숫자는 허용되지 않습니다."),
    NOT_NUMBER_ERROR("숫자만 입력해주세요."),
    INVALID_VALUE_ERROR("1 또는 2만 입력이 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
