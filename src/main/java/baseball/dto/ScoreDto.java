package baseball.dto;

public class ScoreDto {

    private int strike;
    private int ball;

    public ScoreDto(int strike, int ball) {
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
