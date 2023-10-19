package baseball;

public enum Judgement {
    NOTHING("낫싱"),
    BALL("볼"),
    STRIKE("스트라이크");



    String type;


    Judgement(String type) {
        this.type = type;
    }
}
