package baseball.game;

public enum BaseBallGameMessage {
    START_GAME("숫자 야구 게임을 시작합니다.")

    ;

    private final String message;
    BaseBallGameMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
