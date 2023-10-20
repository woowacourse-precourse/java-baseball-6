package baseball.status;

public enum ErrorCode {

    INVALID_LENGTH_INPUT("입력하신 숫자가 3자리 수가 아닙니다."),
    INVALID_FORMAT_INPUT("입력하신 숫자가 1 ~ 9에 해당하지 않습니다."),
    INVALID_DISTINCT_INPUT("입력하신 숫자 중 중복되는 값이 존재합니다.");

    private final String msg;

    ErrorCode(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
