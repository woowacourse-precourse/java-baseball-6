package baseball.view;

public enum GameMessage {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다.\n"),
    PROMPT_FOR_NUMBER("숫자를 입력해주세요 : "),
    RESTART_CHOICE_MESSAGE("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.\n"),
    GAME_SUCCESS_MESSAGE("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTING("낫싱");
    private final String message;
    public String getMessage(){
        return message;
    }
    GameMessage(String message) {
        this.message= message;
    }
    public String formatMessage(Object... args){
        return String.format(message, args);
    }
}
