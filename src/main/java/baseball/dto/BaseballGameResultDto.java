package baseball.dto;

public class BaseballGameResultDto {
    private final int strike;
    private final int ball;

    public BaseballGameResultDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
