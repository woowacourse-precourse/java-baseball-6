package domain;

public class BaseballResultDto {

    private int strike;
    private int ball;

    public BaseballResultDto(int strike, int ball) {
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
