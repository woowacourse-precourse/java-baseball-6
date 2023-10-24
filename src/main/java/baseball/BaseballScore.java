package baseball;

public class BaseballScore {
    private int strike;
    private int ball;
    public BaseballScore(int strike,int ball){
        this.strike=strike;
        this.ball=ball;
    }
    public int get_strike(){
        return strike;
    }
    public int  get_ball(){
        return ball;
    }

}
