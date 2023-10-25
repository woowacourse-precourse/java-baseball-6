package baseball.constant;

public enum GameMessage {

    START("숫자 야구 게임을 시작합니다."),
    REQUIRES_INPUT("숫자를 입력해주세요 : "),
    BALL_AND_STRIKE_FORMAT("%d볼 %d스트라이크\n"),
    ONLY_BALL_FORMAT("%d볼\n"),
    ONLY_STRIKE_FORMAT("%d스트라이크\n"),
    NOTHING("낫싱"),
    WIN("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ASK_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}