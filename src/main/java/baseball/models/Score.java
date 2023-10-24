package baseball.models;

public class Score {
    private int strikes;
    private int balls;

    public int strikeCount(){
        return strikes;
    }

    public int ballCount(){
        return balls;
    }

    public void updateScore(int strikes, int balls){
        this.strikes = strikes;
        this.balls = balls;
    }

    public Score() {
        this.strikes = 0;
        this.balls = 0;
    }

}
