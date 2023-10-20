package baseball.domain;

public enum GameStatus {
    ONGOING(true),
    SUCCESS(false);

    private final boolean is;

    GameStatus(boolean is) {
        this.is = is;
    }

    public boolean to() {
        return is;
    }
}
