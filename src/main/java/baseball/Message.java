package baseball;

public enum Message {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    Message(String message){
        this.message = message;
    }

    public String getMessage(){
        return  message;
    }
}
