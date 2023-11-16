package baseball.game.entity;

public enum NumberBaseBallGameWord {
    START("숫자 야구 게임을 시작합니다."),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NEW_GAME("1"),
    EXIT_GAME("2"),
    RUNNING("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    NumberBaseBallGameWord(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
