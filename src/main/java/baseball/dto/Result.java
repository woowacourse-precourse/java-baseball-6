package baseball.dto;

//TODO: IDE에서 Record로 바꿀 수 있다네요!?
public class Result {
    private final Integer strike;
    private final Integer ball;

    public Result(Integer strike, Integer ball) {
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
