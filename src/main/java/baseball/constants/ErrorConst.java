package baseball.constants;

public enum ErrorConst {
    NULL_INPUT("입력값이 null입니다."),
    OUT_OF_BOUNDARY("입력값이 1~9 사이의 값이 아닙니다."),
    INVALID_LENGTH("입력값의 길이가 유효하지 않습니다."),
    INVALID_INPUT("입력값이 유효하지 않습니다.");

    private final String message;

    ErrorConst(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
