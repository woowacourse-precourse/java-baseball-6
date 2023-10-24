package baseball;

public enum Message {
    STARTGAME_MESSAGE("숫자 야구 게임을 시작합니다."),
    GAMEOVER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INPUT_USERNUMBER_MESSAGE("숫자를 입력해 주세요 : "),
    INPUT_RESTARTOPTION_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INVALID_VALUE("[ERROR] : 잘못된 값이 입력되었습니다."),
    THREE_NUMBERS_REQUIRED("[ERROR] : 숫자를 3개 입력해 주세요."),
    NUMBER_RANGE("[ERROR] : 1에서 9 사이의 숫자만 입력해주세요."),
    UNIQUE_NUMBERS("[ERROR] : 중복되지 않은 숫자를 입력해주세요."),
    INVALID_RESTART_OPTION("[ERROR] : 1과 2만 입력해주세요.");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
