package baseball.Model;


public class Score {

    private int strikes =0;
    private int balls =0;

    public void setScore(int strike, int ball){
        strikes=strike;
        balls=ball;
    }
    public void setStrikes(int strike){
        strikes=strike;
    }
    public void setBalls(int ball){
        balls=ball;
    }
    public int getStrikes(){
        return strikes;
    }
    public int getBalls(){
        return balls;
    }
}
