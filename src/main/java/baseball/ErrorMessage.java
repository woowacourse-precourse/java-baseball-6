package baseball;

public enum ErrorMessage {
    INPUT_NUMERIC_ERROR("1부터 9사이의 숫자를 입력해 주세요"),
    INPUT_DIFFERENT_THREE_NUMBERS("서로 다른 수로 이루어진 %d자리의 수를 입력해 주세요"),
    INPUT_RESTART_ERROR("숫자 1 혹은 2를 입력해 주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
