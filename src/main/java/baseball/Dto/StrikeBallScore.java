package baseball.Dto;

public class StrikeBallScore {
    private int strike;
    private int ball;

    public StrikeBallScore(){
    }

    public int getStrike(){
        return strike;
    }
    public int getBall(){
        return ball;
    }

    public void setStrike(int strike){
        this.strike = strike;
    }
    public void setBall(int ball){
        this.ball = ball;
    }
}
