package baseball;

public class Result {

    private int strike = 0;
    private int ball = 0;

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean onlyBall() {
        return strike == 0 && ball > 0;
    }

    public int getBall() {
        return ball;
    }

    public boolean onlyStrike() {
        return strike > 0 && ball == 0;
    }

    public int getStrike() {
        return strike;
    }
}
