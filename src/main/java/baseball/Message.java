package baseball;

public enum Message {

    GUESS_NUMBER_REQUEST_MESSAGE("숫자를 입력해주세요 : "),
    BALL_MESSAGE("볼 "), STRIKE_MESSAGE("스트라이크"),
    NOTHING_MESSAGE("낫싱"),
    ALL_CORRECT_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    REPEAT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
