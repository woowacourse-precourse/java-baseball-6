package baseball.domain;

public class Round {
    private int ball;
    private int strike;

    public Round() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void incBall() {
        ball += 1;
    }

    public void incStrike() {
        strike += 1;
    }

}
