package baseball;

public class Score {
    private int strike = 0;
    private int ball = 0;

    public void setStrike(){
        this.strike++;
    }
    public void setBall(){
        this.ball++;
    }
    public void init(){
        this.strike = 0;
        this.ball = 0;
    }
    public int getStrike(){
        return strike;
    }
    public int getBall(){
        return ball;
    }
}
