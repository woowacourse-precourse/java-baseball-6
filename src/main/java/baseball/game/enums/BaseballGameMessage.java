package baseball.game.enums;

public enum BaseballGameMessage {

    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    GAME_RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_WIN_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ;

    private final String message;

    BaseballGameMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
