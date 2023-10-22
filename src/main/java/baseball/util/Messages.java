package baseball.util;

public enum Messages {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    GET_USER_NUMBER_MESSAGE("숫자를 입력해주세요: "),
    BALL_COUNT_MESSAGE("볼"),
    STRIKE_COUNT_MESSAGE("스트라이크"),
    NOTHING_MESSAGE("낫싱"),
    GAME_END_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_END_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    private Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
