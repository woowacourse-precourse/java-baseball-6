package baseball.Message;

public enum EndProcessMsg {
    USER_CHOICE_PROMPT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RESTART("1"),
    END("2"),
    END_PROMPT("게임을 종료합니다."),
    ERROR_PROMPT("1 또는 2를 입력해주세요.");

    private final String msg;

    EndProcessMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
