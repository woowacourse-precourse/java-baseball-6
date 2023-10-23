package baseball;


// PROGRESS는 진행상태를 나타낸다, END는 종료상태를 나타낸다
public enum GameStatus {
    PROGRESS(1), END(2);

    private final int progress;

    GameStatus(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

    public static GameStatus getStatus(int progress) {
        if (PROGRESS.progress == progress) {
            return PROGRESS;
        }
        return END;
    }
}
