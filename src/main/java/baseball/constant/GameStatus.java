package baseball.constant;

public enum GameStatus {
    CONTINUE("1"),
    STOP("2");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
