package baseball;

public enum BallStatus {
    NOTING("낫싱"), STRIKE("스트라이크"), BALL("볼");

    private final String value;

    BallStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
