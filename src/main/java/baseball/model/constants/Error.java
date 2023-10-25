package baseball.model.constants;

public enum Error {
    NUMBER_NUMERIC("잘못된 값을 입력했습니다. (숫자가 아닙니다.)"),
    NUMBER_LENGTH_INVALID("잘못된 값을 입력했습니다. (3자리가 아닙니다.)"),
    NUMBER_RANGE_INVALID("잘못된 값을 입력했습니다. (1에서 9 범위가 아닙니다.)"),
    NUMBER_DUPLICATED("잘못된 값을 입력했습니다. (숫자가 중복되었습니다.)"),

    OPTION_INVALID("잘못된 값을 입력했습니다. (1 또는 2가 아닙니다.)");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}