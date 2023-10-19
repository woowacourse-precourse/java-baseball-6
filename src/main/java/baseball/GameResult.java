package baseball;

public class GameResult {

    private Integer strike;

    private Integer ball;

    GameResult(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
