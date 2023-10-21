package baseball;

public class ResultOfGuess {
    private int ball;
    private int strike;

    public ResultOfGuess(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
