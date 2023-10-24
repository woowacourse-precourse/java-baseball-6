package error;

public enum ErrorMessage {

    INVALID_SIZE("입력한 숫자의 개수가 맞지 않습니다."),
    INVALID_NUMBER_RANGE("각 자릿수는 지정해둔 범위 사이어야 합니다."),
    INVALID_NUMBER("입력값은 숫자 여야 합니다."),
    DUPLICATE_NUMBER("입력값은 중복될 수 없습니다."),
    INVALID_INPUT_COMMAND("커맨드는 1과 2만 가능합니다."),
    GAME_ERROR("게임 중 오류가 발생했습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}