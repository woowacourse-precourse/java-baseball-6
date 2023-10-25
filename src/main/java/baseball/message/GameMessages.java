package baseball.message;

public enum GameMessages {
    RESTART_COMMENT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    FINISH_COMMENT("게임 종료"),
    START_COMMENT("숫자 야구 게임을 시작합니다."),
    GAME_END_COMMENT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),

    NUMBER_INPUT_COMMENT("숫자를 입력해주세요 : "),
    THREE_STRIKE_COMMENT("3스트라이크");

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
