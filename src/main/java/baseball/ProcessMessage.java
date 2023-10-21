package baseball;

public enum ProcessMessage {
    START("숫자 야구 게임을 시작합니다."),
    THREE_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
