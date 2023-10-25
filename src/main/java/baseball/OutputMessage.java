package baseball;

public enum OutputMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT_PLAYER_NUMBER("숫자를 입력해주세요 : "),
    INNING_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INPUT_GAME_COMMAND("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_END("숫자 야구 게임을 종료합니다."),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
