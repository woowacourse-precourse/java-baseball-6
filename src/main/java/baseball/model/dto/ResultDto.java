package baseball.model.dto;

public class ResultDto {

    private final Integer strike;
    private final Integer ball;

    public ResultDto(Integer strike, Integer ball) {
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