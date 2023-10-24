package baseball.constant;

public enum GameStatus {

    START,
    PROGRESS,
    THREE_STRIKE;

    public boolean isProgress() {
        return this != THREE_STRIKE;
    }
}
