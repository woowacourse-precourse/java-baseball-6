package baseball.domain;

import baseball.constant.Constant;

public class GameResult {
    private final int strikes;
    private final int balls;

    private static final int INITIAL_STRIKES = Constant.ZERO.getConstant();
    private static final int INITIAL_BALLS = Constant.ZERO.getConstant();
    private final int NUMBER_SIZE = Constant.NUMBER_SIZE.getConstant();

    public static GameResult initialResult() {
        return new GameResult(INITIAL_STRIKES, INITIAL_BALLS);
    }

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isGameOver() {
        return strikes == NUMBER_SIZE;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
