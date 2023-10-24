package baseball.utill;

public enum ExceptionMessage {
    INVALID_BALL_COUNT("올바른 값을 입력해 주세요."),
    INVALID_GAME_COMMAND("1, 2 중 입력해 주세요."),
    INVALID_LENGTH("세 자리 자연수를 입력해 주세요."),
    DUPLICATE_LIST("중복된 값이 존재합니다")
    ;
    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}