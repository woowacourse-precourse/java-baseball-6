package baseball.model;

public class BallAndStrike {
    private int ball;
    private int strike;

    public BallAndStrike(){
        ball = 0;
        strike = 0;
    }

    public void addBall() {
        this.ball++;
    }

    public void addStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
