package baseball.dto;

public class ScoreDto {

    private final int strike;
    private final int ball;

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
