package baseball.core.code;


public enum Message {
    START("숫자 야구 게임을 시작합니다."),
    GAME_RESTART_OR_QUIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    ;

    private String description;

    private Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
