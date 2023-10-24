package baseball.domain;

public class BaseBall {
    private int ball;
    private int strike;

    public void addBall(){
        this.ball++;
    }
    public void addStrike(){
        this.strike++;
    }
    public int getBall(){
        return this.ball;
    }
    public int getStrike(){
        return this.strike;
    }

    public boolean isNothing() {
        return (this.ball==0&&this.strike==0);
    }
}
