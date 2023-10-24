package baseball.domain.status;

public enum GameStatus {
    RESTART("1"),
    FINISH("2");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
