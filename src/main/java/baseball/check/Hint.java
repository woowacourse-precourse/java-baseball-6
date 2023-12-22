package baseball.check;

public class Hint {
    private int strike;
    private int ball;

    public Hint( ) {
        this.strike = 0;
        this.ball = 0;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void strikeCounting(){
        this.strike++;
    }

    public void ballCounting(){
        this.ball++;
    }
}
