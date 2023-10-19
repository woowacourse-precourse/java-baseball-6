package baseball.enums;

public enum Message {
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER_PROMPT("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    END_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_END_PROMPT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
