package baseball.io;

public enum IOMessage {
    GAME_BEGIN("야구 게임을 시작합니다."),
    TRY_NUMBER("숫자를 입력해주세요 : "),
    WIN_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_AGAIN("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_END("게임 종료"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}