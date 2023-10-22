package baseball.Message;

public enum BaseBallGameMsg {
    PROMPT_PLAY_GAME("숫자를 입력해주세요 : "),
    THREE_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    BALL("볼 "),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String msg;

    BaseBallGameMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
