package baseball.constant;

public enum GameMessage {

    START("숫자 야구 게임을 시작합니다."),
    REQUIRES_INPUT("숫자를 입력해주세요 : "),
    RESULT_FORMAT("%d볼 %d스트라이크"),
    NOTHING("낫싱"),
    WIN("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_PROMPT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}