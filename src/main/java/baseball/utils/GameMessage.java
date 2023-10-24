package baseball.utils;

public enum GameMessage {
    BASEBALL_START("숫자 야구 게임을 시작합니다."),
    REQUIRED_INPUT_NUMBER("숫자를 입력해주세요 : "),
    EXIT_GAME("게임 종료"),
    DECIDE_CONTINUE_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");


    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
