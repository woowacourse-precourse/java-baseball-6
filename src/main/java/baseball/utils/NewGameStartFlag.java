package baseball.utils;

public enum NewGameStartFlag {
    START(1),
    END(2),
    UNAVAILABLE(-1),
    ;

    final int restartFlag;

    NewGameStartFlag(int restartFlag) {
        this.restartFlag = restartFlag;
    }

    public static NewGameStartFlag getNewGameStart(int restartFlag) {
        if (restartFlag == 1) {
            return NewGameStartFlag.START;
        } else if (restartFlag == 2) {
            return NewGameStartFlag.END;
        }
        return NewGameStartFlag.UNAVAILABLE;
    }
}
