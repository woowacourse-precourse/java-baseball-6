package baseball;

public enum SystemMessage {
    INPUTREQUEST("숫자를 입력해주세요 : "),

    STARTGAME("숫자 야구 게임을 시작합니다."),
    CONTINUEGAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ENDGAMEM("게임이 종료되었습니다."),

    GAMESTOP("2"),
    GAMECONTINUE("1");
    final private String message;

    SystemMessage(String message){
        this.message = message;
    }
    public String get(){
        return message;
    }
}
