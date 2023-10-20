package baseball.util.enums;

public enum PitchType {
    NOTHING("낫싱"), STRIKE("스트라이크 "), BALL("볼 ")
    ;
    private final String value;

    PitchType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
