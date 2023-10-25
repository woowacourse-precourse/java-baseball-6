package baseball.view;

public enum PrintMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    REQUEST_INPUT_NUMBER("숫자를 입력해주세요 : "),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    ASK_KEEP_GOING_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
