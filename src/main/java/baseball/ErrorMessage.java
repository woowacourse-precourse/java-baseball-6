package baseball;

public enum ErrorMessage {
    EMPTY_VALUE("빈 값은 입력할 수 없습니다."),
    INVALID_LENGTH("세 자리 이외의 값은 입력할 수 없습니다."),
    NONE_NUMERIC("숫자 이외의 값은 입력할 수 없습니다."),
    CONTAINS_ZERO("0은 입력할 수 없습니다."),
    NOT_REQUIRED_RESTART_INPUT("1과 2 이외의 숫자는 입력할 수 없습니다."),
    IS_DUPLICATED_VALUE("서로 중복되는 숫자는 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
