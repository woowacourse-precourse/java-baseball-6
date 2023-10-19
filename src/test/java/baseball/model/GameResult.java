package baseball.model;

public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String resultMessage;

    GameResult(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
