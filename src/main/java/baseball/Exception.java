package baseball;

public enum Exception {
    ALREADY_EXIST_NUMBER("중복된 숫자가 있습니다."),
    INVALID_SIZE_OF_INPUT("3개의 숫자를 입력해주세요."),
    INVALID_RANGE_OF_INPUT("1~9 사이의 숫자를 입력해주세요."),
    INVALID_TYPE_OF_INPUT("숫자를 입력해주세요."),
    INVALID_STRIKE_OR_BALL_COUNT("스트라이크와 볼은 0보다 작을 수 없습니다."),
    INVALID_INPUT("잘못된 입력입니다."),
    ONLY_1_OR_2("1 또는 2를 입력해주세요."),;

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
