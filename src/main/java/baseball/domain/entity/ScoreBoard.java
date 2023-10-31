package baseball.domain.entity;

public class ScoreBoard {
    private int ball;
    private int strike;

    public ScoreBoard() {
        this.ball = 0;
        this.strike = 0;
    }

    public void countBall() {
        ball++;
    }

    public void countStrike() {
        strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
