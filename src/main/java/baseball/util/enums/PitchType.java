package baseball.util.enums;

public enum PitchType {
    NOTHING("낫싱"), STRIKE("스트라이크"), BALL("볼 ")
    ;
    private final String type;

    PitchType(String value) {
        this.type = value;
    }

    public String getType() {
        return type;
    }
}
