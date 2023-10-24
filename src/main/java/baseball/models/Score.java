package baseball.models;

public class Score {
    private int strikes;
    private int balls;

    public int getStrikeCount(){
        return strikes;
    }

    public int getBallCount(){
        return balls;
    }

    public void setScore(int strikes, int balls){
        this.strikes = strikes;
        this.balls = balls;
    }

    public Score() {
        this.strikes = 0;
        this.balls = 0;
    }

}
