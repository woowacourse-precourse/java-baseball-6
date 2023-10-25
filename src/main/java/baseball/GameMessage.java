package baseball;

public enum GameMessage {
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    START_GAME_MESSAGE("숫자 야구 게임을 시작합니다."),
    THREE_STRIKE_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NEW_GAME_START_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NEW_GAME("1"),
    QUIT("2"),
    MIN_NUMBER(1),
    MAX_NUMBER(9),
    BALL_NUMBER_GROUP_SIZE(3),
    STRIKE_COUNT(3),
    NOTHING_COUNT(3),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    BLANK(" "),
    ;

    private String message;
    private Integer number;

    GameMessage(String message) {
        this.message = message;
    }

    GameMessage(Integer number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public Integer getNumber() {
        return number;
    }
}
