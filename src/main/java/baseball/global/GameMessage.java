package baseball.global;

public enum GameMessage {

    GAME_START_MESSAGE("숫자 야구를 시작합니다.\n"),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요: ");

    public final String message;

    GameMessage(String message) {
        this.message = message;
    }
}
