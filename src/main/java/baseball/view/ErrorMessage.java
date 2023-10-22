package baseball.view;

public enum ErrorMessage {
    NUMBER_RANGE("숫자는 1부터 9까지의 수로만 이뤄져야 합니다."),
    NUMBER_TYPE("숫자로만 구성되어야 합니다."),
    NUMBER_SIZE("숫자의 길이는 3이여야 합니다."),
    NUMBER_DUPLICATE("중복되는 수가 존재할 수 없습니다."),
    RESTART_COMMAND("1 또는 2를 입력하세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
