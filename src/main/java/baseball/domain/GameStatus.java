package baseball.domain;

public enum GameStatus {
    RUN, CLEAR, END;

    public static GameStatus from(int strikeCount) {
        if (strikeCount == Balls.BALLS_SIZE) {
            return CLEAR;
        }
        return RUN;
    }

    public static GameStatus from(GameCommand gameCommand) {
        if (gameCommand == GameCommand.EXIT) {
            return END;
        }
        return RUN;
    }

    public boolean isNotClear() {
        return this != GameStatus.CLEAR;
    }

    public boolean isNotEnd() {
        return this != GameStatus.END;
    }
}
