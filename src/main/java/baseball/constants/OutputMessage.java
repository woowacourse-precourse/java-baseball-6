package baseball.constants;

public enum OutputMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_EXIT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
