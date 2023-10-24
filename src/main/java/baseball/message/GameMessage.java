package baseball.message;

public enum GameMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_COMPLETE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    USER_INPUT("숫자를 입력해주세요 : "),
    INVALID_NUMBER_FORMAT_ERROR("1~9까지의 세자리의 숫자가 아닙니다."),
    DUPLICATE_NUMBER_ERROR("중복된 숫자가 있습니다."),
    INVALID_RESTART_CHOICE_ERROR("1 또는 2가 아닙니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

