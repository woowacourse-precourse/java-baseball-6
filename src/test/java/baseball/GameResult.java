package baseball;

public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("NOTHING");

    private String resultMessage;

    GameResult(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
