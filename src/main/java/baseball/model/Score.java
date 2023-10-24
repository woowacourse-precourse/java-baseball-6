package baseball.model;

public class Score {

    private int total;
    private int strikes;
    private int balls;

    public int getTotal(){
        return total;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public Score() {
        this.total = 0;
        this.strikes = 0;
        this.balls = 0;
    }

    public void setCount(int total,int strikes){
        this.total = total;
        this.strikes = strikes;
        this.balls = total - strikes;
    }
}
