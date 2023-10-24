package baseball.constants;

public enum InputMessage {
    INPUT_PLAYER_NUMBERS("숫자를 입력해주세요 : "),
    RESTART_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
