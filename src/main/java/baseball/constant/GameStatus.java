package baseball.constant;

public enum GameStatus {
    CONTINUE("1"),
    STOP("2");

    public final String status;

    GameStatus(String status) {
        this.status = status;
    }
}
