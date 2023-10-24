package baseball;

public class BallResultDto {
    int ball;
    int strike;

    public BallResultDto(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
