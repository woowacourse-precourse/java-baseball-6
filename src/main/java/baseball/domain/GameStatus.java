package baseball.domain;

public enum GameStatus {
    RUN, CLEAR, END;

    public static GameStatus from(int strikeCount) {
        if (isAllStrike(strikeCount)) {
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

    private static boolean isAllStrike(int strikeCount) {
        return strikeCount == Ball.MAX_POSITION;
    }

    public boolean isNotClear() {
        return this != GameStatus.CLEAR;
    }

    public boolean isNotEnd() {
        return this != GameStatus.END;
    }
}
