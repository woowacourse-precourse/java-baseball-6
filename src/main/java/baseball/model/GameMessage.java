package baseball.model;

public enum GameMessage {
    START_GAME_MESSAGE("숫자 야구 게임을 시작합니다."),
    USER_INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    SUCCESS_GAME_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_GAME_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    INPUT_LENGTH_ERROR_MESSAGE("3자리수를 입력해주세요."),
    INPUT_DIGIT_ERROR_MESSAGE("숫자가 아닌 값이 입력되었습니다."),
    INPUT_DUPLICATION_ERROR_MESSAGE("중복된 숫자가 있습니다."),
    INPUT_RESTART_ERROR_MESSAGE("1 또는 2를 입력해주세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
