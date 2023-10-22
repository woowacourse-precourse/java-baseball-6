package baseball.enums;

public enum GameStatus {
    PLAY("1"),
    EXIT("2");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public boolean equals(String status) {
        return this.status.equals(status);
    }
}
