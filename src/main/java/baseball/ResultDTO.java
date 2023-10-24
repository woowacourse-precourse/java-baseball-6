package baseball;

public class ResultDTO {
    private int strike;
    private int ball;

    public ResultDTO(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return this.strike;
    }
}
