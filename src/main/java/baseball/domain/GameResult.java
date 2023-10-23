package baseball.domain;

public class GameResult {
    private final int strikes;
    private final int balls;

    private static final int INITIAL_STRIKES = 0;
    private static final int INITIAL_BALLS = 0;

    public static GameResult initialResult() {
        return new GameResult(INITIAL_STRIKES, INITIAL_BALLS);
    }

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameOver() {
        return strikes == 3;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
