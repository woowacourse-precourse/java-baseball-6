package constants;

public enum MessageType {
    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    STRIKE_3("3스트라이크"),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    NEW_GAME("1");

    private String message;

    MessageType(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
