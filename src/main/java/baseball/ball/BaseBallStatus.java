package baseball.ball;

public enum BaseBallStatus {
    GUESSING,
    CORRECT;

    public boolean isGuessing() {
        return this == GUESSING;
    }
}
