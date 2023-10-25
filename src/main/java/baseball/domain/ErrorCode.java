package baseball.domain;

public enum ErrorCode {

    NOT_SINGLE_NUMBER("1-9 사이의 숫자를 입력해 주세요."),
    NOT_OTHER_NUMBERS("서로 다른 숫자를 입력해 주세요."),
    NOT_NUMBER_STRING("숫자를 입력해 주세요."),
    INVALID_BALL_SIZE("3자리의 숫자를 입력해 주세요."),
    INVALID_OPTION_NUMBER("1(재시작) 또는 2(종료)를 입력해주세요."),
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
