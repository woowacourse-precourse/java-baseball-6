package baseball.common;

public enum ErrorCode {
    INVALID_RANGE("볼의 범위는 cond1부터 cond2까지 입니다."),
    INVALID_NUMBER("맞춰야할 볼의 개수는 cond1개 입니다."),
    INVALID_COMMAND("재시작은 (cond1), 종료는 (cond2) 입니다."),
    INVALID_INT("숫자를 입력해주세요.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public ErrorCode with(String cond1, String cond2) {
        message = message
                .replace("cond1", cond1)
                .replace("cond2", cond2);
        return this;
    }

    public ErrorCode with(Size cond) {
        return with(Integer.toString(cond.getValue()), "");
    }

    public ErrorCode with(Size cond1, Size cond2) {
        return with(Integer.toString(cond1.getValue()), Integer.toString(cond2.getValue()));
    }

    public ErrorCode with(Command cond1, Command cond2) {
        return with(cond1.getKey(), cond2.getKey());
    }
}
