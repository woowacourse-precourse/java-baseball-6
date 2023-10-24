package baseball.model.constants;

public enum Exception {
    PLAYER_NUMBERS_NON_NUMBER("잘못된 값을 입력했습니다. (숫자가 아닙니다.)"),
    PLAYER_NUMBERS_LENGTH_INVALID("잘못된 값을 입력했습니다. (3자리가 아닙니다.)"),
    PLAYER_NUMBERS_RANGE_INVALID("잘못된 값을 입력했습니다. (1에서 9 범위가 아닙니다.)"),
    PLAYER_NUMBERS_DUPLICATED("잘못된 값을 입력했습니다. (숫자가 중복되었습니다.)"),

    RESTART_OPTION_NON_NUMBER("잘못된 값을 입력했습니다. (숫자가 아닙니다.)"),
    RESTART_OPTION_LENGTH_INVALID("잘못된 값을 입력했습니다. (1자리가 아닙니다.)"),
    RESTART_OPTION_RANGE_INVALID("잘못된 값을 입력했습니다. (1 또는 2가 아닙니다.)");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}