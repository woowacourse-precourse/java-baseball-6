package baseball.view;

public enum UIMessage {
    GAME_INTRO("숫자 야구 게임을 시작합니다."),
    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    END_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ERROR("잘못된 입력값입니다.");

    private final String message;

    UIMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
