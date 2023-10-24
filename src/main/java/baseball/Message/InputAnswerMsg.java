package baseball.Message;

public enum InputAnswerMsg {
    IS_INTEGER("숫자만 입력해주세요.\n입력값 : "),
    DUPLICATE("중복된 정수를 입력할 수 없습니다.\n입력값 : "),
    RANGE("범위를 벗어난 정수를 입력할 수 없습니다.\n입력값 : ");
    private final String msg;

    InputAnswerMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
