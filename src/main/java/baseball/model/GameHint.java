package baseball.model;

public enum GameHint {
    STRIKE("스트라이크", 0),
    BALL("볼", 1),
    NOTHING("낫싱", 2);

    private final String message;
    private final int resultIndex;

    GameHint(String message, int resultIndex) {
        this.message = message;
        this.resultIndex = resultIndex;
    }

    public String getMessage() {
        return message;
    }

    public int getResultIndex() {
        return resultIndex;
    }
}
