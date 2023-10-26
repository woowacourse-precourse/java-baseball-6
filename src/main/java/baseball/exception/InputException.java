package baseball.exception;

public enum InputException {
    INVALID_NULL("입력값은 Null 값이 아니어야 합니다."),
    NOT_A_NUMBER("입력값은 숫자이어야 합니다."),
    INVALID_NUMBER_THREE_LENGTH("입력값의 길이는 3이어야 합니다."),
    NOT_ONE_OR_TWO("입력값으로는 1 또는 2를 입력해야 합니다."),
    DUPLICATED_NUMBER("입력값으로는 중복되지 않은 숫자를 입력해야 합니다.");

    private final String message;

    InputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}