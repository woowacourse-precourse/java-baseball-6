package baseball.enums;

public enum InputMessage {
    START_MSG("숫자 야구 게임을 시작합니다."),
    INPUT_GUIDE_MSG("숫자를 입력해주세요 : "),
    RESTART_MSG("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String msg;

    InputMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
