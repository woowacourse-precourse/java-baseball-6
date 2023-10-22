package baseball.view;

public enum GameMessage {
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    INPUT_RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    START_GAME("숫자 야구 게임을 시작합니다."),
    SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    END_GAME("숫자 야구 게임을 종료합니다.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
