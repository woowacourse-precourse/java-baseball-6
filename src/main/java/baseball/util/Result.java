package baseball.util;

public enum Result {
    BALL("볼 "),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String name;

    Result(String name) {
        this.name = name;
    }

    public String is() {
        return name;
    }
}
