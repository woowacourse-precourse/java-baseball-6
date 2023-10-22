package baseball.message;

public enum CountMessage {

    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    CountMessage(String message) {
    }

    @Override
    public String toString() {
        return BALL + " " + STRIKE;
    }
}
