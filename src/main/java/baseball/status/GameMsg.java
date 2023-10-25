package baseball.status;

public enum GameMsg {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_OVER("--게임 종료--"),
    SUCCESS_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    REPLAY_OR_OVER_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    SET_INPUT("숫자를 입력해주세요 : "),
    NOTHING("낫싱"),
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    BALL_AND_STRIKE("%d볼 %d스트라이크");

    private final String msg;

    GameMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
