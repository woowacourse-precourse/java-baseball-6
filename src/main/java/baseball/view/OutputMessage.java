package baseball.view;

public enum OutputMessage {

    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ;

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
