package baseball.entity;

public class Score {
    private int ball;
    private int strike;

    public int getBall(){
        return ball;
    }

    public int getStrike(){
        return strike;
    }

    public void setBall(int ball){
        this.ball = ball;
    }

    public void setStrike(int strike){
        this.strike = strike;
    }
}
