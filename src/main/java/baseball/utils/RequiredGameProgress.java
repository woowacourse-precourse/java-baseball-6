package baseball.utils;

public enum RequiredGameProgress {
    STRIKE_INDEX_IN_NUMBER_RESULT(0),
    BALL_INDEX_IN_NUMBER_RESULT(1),
    REQUIRED_EXIT_WIN_STRIKES(3);

    private final int progress;

    RequiredGameProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }
}
