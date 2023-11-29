package baseball.model;

public class Result {
    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return ball;
    }

    public void addBall() {
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public void addStrike() {
        this.strike++;
    }
    
}
