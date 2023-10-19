package baseball.domain;

public enum GameResult {
    CONTINUE, END;

    public static GameResult from(int strikeCount) {
        if (strikeCount == Balls.BALLS_SIZE) {
            return END;
        }
        return CONTINUE;
    }
}
