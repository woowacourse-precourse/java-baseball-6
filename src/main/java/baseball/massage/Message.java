package baseball.massage;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료!"),
    REQUEST_USER_NUMBER("숫자를 입력해주세요 : "),
    NOTHING("낫싱"),
    STRIKE("스트라이크"),
    BALL("볼"),
    REQUEST_CHOICE_NUMBER("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Message(String message){
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
