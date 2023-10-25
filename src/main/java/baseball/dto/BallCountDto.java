package baseball.dto;

public class BallCountDto {

    private int strike;
    private int ball;
    public BallCountDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int  showStrike() {
        return this.strike;
    }
    public int  showBall() {
        return this.ball;
    }

}
