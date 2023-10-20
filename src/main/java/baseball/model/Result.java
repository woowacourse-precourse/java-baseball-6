package baseball.model;

public class Result {
    private static final int GAME_FINISH_COUNT = 3;
    private final int strike;
    private final int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isGameFinish() {
        if (strike == GAME_FINISH_COUNT) {
            return true;
        }
        return false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
