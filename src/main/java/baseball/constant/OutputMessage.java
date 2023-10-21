package baseball.constant;

public enum OutputMessage {

    GAME_START("숫자 야구 게임을 시작합니다."),
    PLAYER_INPUT_GUIDE("숫자를 입력해주세요 : "),
    BALL("%d볼 "),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱");

    private final String message;


    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
