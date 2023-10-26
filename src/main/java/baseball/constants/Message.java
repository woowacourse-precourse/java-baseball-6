package baseball.constants;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT_PLAYER_NUMBERS("숫자를 입력해주세요 : "),
    RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_EXIT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크"),
    BLANK(" ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
