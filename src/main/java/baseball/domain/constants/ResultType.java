package baseball.domain.constants;

public enum ResultType {

    NOTHING("낫싱"),
    ONLY_BALL("%d볼"),
    ONLY_STRIKE("%d스트라이크"),
    BALL_AND_STRIKE("%d볼 %d스트라이크");

    private final String value;

    ResultType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
