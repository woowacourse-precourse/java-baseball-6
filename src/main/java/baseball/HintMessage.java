package baseball;

public enum HintMessage {
    ALLSTRIKE("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NOTHINGMESSAGE("낫싱"),
    STRIKEFORMAT("%d스트라이크"),
    BALLFORMAT("%d볼"),
    BALLSTRIKFORMAT("%d볼 %d스트라이크");

    
    private final String message;

    HintMessage(String message) {
        this.message = message;
    }
    public String get() {
        return message;
    }
}
