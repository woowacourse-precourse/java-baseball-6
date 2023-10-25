package baseball.util;

public enum Err {
    DUPLICATE_NUMBERS("서로 다른 숫자만 있어야 합니다."),
    INVALID_NUMBERS_SIZE("세 자리의 숫자가 있어야 합니다."),
    INVALID_GAME_STATUS("게임 재실행 또는 종료하려면, 1 또는 2만 입력해야 합니다."),
    INVALID_NUMERIC_INPUT("숫자 문자만 입력할 수 있습니다."),
    OUT_OF_RANGE_NUMBERS("1부터 9까지의 범위에 있는 숫자만 가능합니다.");

    private final String message;

    Err(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
