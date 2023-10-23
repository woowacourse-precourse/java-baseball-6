package baseball;

public class NumbersScoreDto {
    private int strike;
    private int ball;

    public NumbersScoreDto() {
    }

    public NumbersScoreDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Score toModel() {
        return new Score(this.strike, this.ball);
    }
}
