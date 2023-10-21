package baseball.domain;

public enum GameStatus {
    RUN, CLEAR, END;

    public static GameStatus from(int strikeCount) {
        if (isClear(strikeCount)) {
            return CLEAR;
        }
        return RUN;
    }

    public static GameStatus from(GameCommand gameCommand) {
        if (gameCommand.isEnd()) {
            return END;
        }
        return RUN;
    }

    private static boolean isClear(int strikeCount) {
        return strikeCount == Baseballs.BALLS_SIZE;
    }

    public boolean isNotClear() {
        return this != GameStatus.CLEAR;
    }

    public boolean isNotEnd() {
        return this != GameStatus.END;
    }
}
