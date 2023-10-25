package baseball.constants;

public enum Messages {
    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL_MESSAGE("%d볼\n"),
    STRIKE_MESSAGE("%d스트라이크\n"),
    BALL_AND_STRIKE_MESSAGE("%d볼 %d스트라이크\n"),
    NOTHING_MESSAGE("낫싱\n"),
    ANSWER_MESSAGE("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    START_MESSAGE("숫자 야구 게임을 시작합니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
