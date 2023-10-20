package baseball;

public enum ProcessMessage {
    START_MESSAGE("숫자 야구 게임을 시작합니다.");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
