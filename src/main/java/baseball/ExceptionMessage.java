package baseball;

public enum ExceptionMessage {
    BLANK("빈 값을 입력했습니다."),
    INVALID_NUMBER_LENGTH("세 자리 숫자만 입력 가능합니다."),
    INVALID_GAME_COMMAND_LENGTH("한 자리 숫자만 입력 가능합니다."),
    INVALID_GAME_COMMAND("1 또는 2만 입력 가능합니다."),
    NOT_NUMERIC("숫자만 입력 가능합니다."),
    DUPLICATE_NUMBER("서로 다른 세 자리 숫자를 입력해야 합니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
