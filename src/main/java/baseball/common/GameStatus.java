package baseball.common;

public enum GameStatus {
    ONPLAYING("1", true), END("2", false);

    private String number;
    private boolean start;

    GameStatus(String number, boolean start) {
        this.number = number;
        this.start = start;
    }

    public boolean isEnd() {
        return this == END;
    }
}
