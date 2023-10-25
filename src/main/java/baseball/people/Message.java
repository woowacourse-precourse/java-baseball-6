package baseball.people;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    BALL("%d볼 "),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱"),
    DEMAND_INPUT("숫자를 입력해주세요 : "),
    ASK_TO_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. "),
    RESTART("1"),
    QUIT("2");

    private final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
