package baseball.enums;

public enum OutputMessage {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    MATCHING_ALL("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String msg;

    OutputMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
