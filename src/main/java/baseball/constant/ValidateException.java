package baseball.constant;


public enum ValidateException {
    INPUT_NUMBER_EXCEPTION("1~9 사이의 숫자로 입력이 되어야 합니다!"),
    INPUT_NUMBER_LENGTH_EXCEPTION("숫자의 길이는 3입니다!"),
    RESTART_INPUT_NUMBER_EXCEPTION("재시작 관련 입력은 1 또는 2의 숫자여야 합니다!"),
    RESTART_INPUT_NUMBER_LENGTH_EXCEPTION("1 또는 2 의 숫자로 한 번만 입력해주세요!"),
    DUPLICATE_NUMBER_EXCEPTION("서로 다른 숫자가 와야 합니다! ");

    private final String msg;

    ValidateException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}