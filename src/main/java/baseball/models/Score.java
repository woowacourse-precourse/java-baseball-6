package baseball.models;

public class Score {
    int strike;
    int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void changeScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
}
