package baseball.common;

public enum ErrorCode {
    INVALID_INT("볼의 범위는 cond1부터 cond2까지 입니다."),
    INVALID_NUMBER("맞춰야할 볼의 개수는 cond1개 입니다."),
    INVALID_COMMAND("재시작은 (cond1), 종료는 (cond2) 입니다.");

    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage(String cond1, String cond2) {
        return message
                .replace("cond1", cond1)
                .replace("cond2", cond2);
    }

    public String getMessage(String cond) {
        return getMessage(cond, "");
    }
}
