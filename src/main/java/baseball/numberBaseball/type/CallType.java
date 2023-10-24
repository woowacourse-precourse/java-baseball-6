package baseball.numberBaseball.type;

public enum CallType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    RESTART("1"),
    FINISH("2");

    private final String onStringValue;

    CallType(String onStringValue){
        this.onStringValue = onStringValue;
    }

    public String getOnStatueType(){
        return onStringValue;
    }
}
