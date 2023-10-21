package baseball.util;

public enum Err {
    ERROR_NUMBERS_DUPLICATION_MESSAGE("[ERROR] 서로 다른 숫자를 입력해주세요."),
    ERROR_NOT_THREE_SIZE_MESSAGE("[ERROR] 3자리의 숫자를 입력해주세요."),
    ERROR_GAME_ACTION_INPUT_MESSAGE("[ERROR] 게임 재실행 또는 종료에 대한 입력 값은 1 또는 2만 가능합니다."),
    ERROR_INPUT_NOT_NUMBERS_MESSAGE("[ERROR] 숫자만 입력할 수 있습니다."),
    ERROR_INPUT_SCOPE_MESSAGE("[ERROR] 1부터 9까지의 범위에 있는 숫자만 입력할 수 있습니다.");

    private final String message;

    Err(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
