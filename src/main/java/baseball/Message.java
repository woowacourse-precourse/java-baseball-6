package baseball;

public enum Message {

    START("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    EXIT("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART("1"),
    COMPLETE("2"),
    CHOICE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL("볼"),
    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    DESTINATION("3스트라이크"),
    INPUT_THREE_NUMBER("[ERROR] 세자리 숫자를 입력해주세요"),
    INPUT_RIGHT_NUMBER("[ERROR] 1 또는 2를 입력해주세요");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
