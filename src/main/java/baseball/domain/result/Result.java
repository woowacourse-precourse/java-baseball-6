package baseball.domain.result;

public class Result {

    private static final int NUMBER_OF_GAME_CLEAR_STRIKES = 3;

    private final Integer ball;
    private final Integer strike;

    public Result(Integer ball, Integer strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public boolean isGameClear() {
        return strike.equals(NUMBER_OF_GAME_CLEAR_STRIKES);
    }
}
