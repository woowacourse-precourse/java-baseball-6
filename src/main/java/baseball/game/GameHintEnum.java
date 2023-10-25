package baseball.game;

public enum GameHintEnum {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String hintMessage;

    GameHintEnum(String hintMessage) {
        this.hintMessage = hintMessage;
    }

    public String getHintMessage(){
        return hintMessage;
    }
}
