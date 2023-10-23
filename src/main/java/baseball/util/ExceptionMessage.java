package baseball.util;

public enum ExceptionMessage {
    INVALID_NUMERIC_INPUT("입력은 숫자만 가능합니다."),
    INVALID_LENGTH("숫자는 세자리만 입력 가능합니다."),
    INVALID_NUMBER_RANGE("숫자는 1부터 9까지만 입력이 가능합니다."),
    INVALID_GAME_COMMAND("1 또는 2를 입력해야 합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
