package baseball;

public enum InfoMessage {
    START("숫자 야구 게임을 시작합니다."),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;
    InfoMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
