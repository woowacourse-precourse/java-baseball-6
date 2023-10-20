package baseball;

public enum ErrorMessage {
    INPUT_NUMERIC_ERROR("숫자를 입력해 주세요"),
    INPUT_ONE_TO_NINE_DIFFERENT_THREE_NUMBERS("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해 주세요"),
    INPUT_RESTART_ERROR("숫자 1 혹은 2를 입력해 주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
