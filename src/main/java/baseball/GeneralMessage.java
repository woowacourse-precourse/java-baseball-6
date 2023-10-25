package baseball;

public enum GeneralMessage {
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    REQUEST_INPUT_MESSAGE("숫자를 입력해주세요 : "),
    NOTHING_MESSAGE("낫싱"),
    THREE_STRIKE_MESSAGE("3스트라이크\n3개의 숫자를 모두 맞히셨습니다!\n게임 종료"),
    REQUEST_RETRY_INPUT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    GeneralMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return (message);
    }
}
