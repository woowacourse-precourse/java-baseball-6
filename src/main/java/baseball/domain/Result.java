package baseball.domain;

public enum Result {
    STRIKE("스트라이크"), BALL("볼"), OUT("아웃"), NOTHING("낫싱");

    private final String name;

    Result(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
