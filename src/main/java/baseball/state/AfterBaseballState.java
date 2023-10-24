package baseball.state;

public enum AfterBaseballState {
    IS_RESTART,
    IS_END,
    ;

    public boolean isRestart() {
        return this == IS_RESTART;
    }

    public boolean isEnd() {
        return this == IS_END;
    }
}
