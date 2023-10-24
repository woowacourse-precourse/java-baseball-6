package baseball;

public enum BallCount {

    BALL("볼"),
    STRIKE("스트라이크");

    private final String callName;

    BallCount(String callName){
        this.callName = callName;
    }

    public String getCallName(){
        return callName;
    }

}
