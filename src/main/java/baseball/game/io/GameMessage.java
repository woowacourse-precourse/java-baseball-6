package baseball.game.io;

public enum GameMessage {

    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    GAME_FINISH_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RETRY_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
