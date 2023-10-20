package baseball.constant;

public enum BaseballString {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요"),
    STRIKE_ALL_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INPUT_RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL_MESSAGE("볼"),
    STRIKE_MESSAGE("스트라이크"),
    NOTHING_MESSAGE("낫싱"),
    RESTART_INPUT("1"),
    ENDGAME_INPUT("2"),
    ;
    private final String message;

    BaseballString(final String _message) {
        message = _message;
    }

    @Override
    public String toString() {
        return message;
    }
}
