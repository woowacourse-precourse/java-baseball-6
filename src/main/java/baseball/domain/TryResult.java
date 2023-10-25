package baseball.domain;

public enum TryResult {
    BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

    private final String resultName;

    TryResult(String resultName) {
        this.resultName = resultName;
    }

    public String getMessage() {
        return resultName;
    }
}
