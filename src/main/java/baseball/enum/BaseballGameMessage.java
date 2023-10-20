package baseball;

public enum BaseballGameMessage {

    START_GAME("숫자 야구 게임을 시작합니다."),
    REQUEST_USER_INPUT("숫자를 입력해주세요 : "),
    QUIT_OR_START_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private final String message;

    BaseballGameMessage(String message) { this.message = message; }
    
    @Override
    public String toString() {
        return message;
    }
    
}
