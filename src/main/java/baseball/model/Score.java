package baseball.model;

public class Score {
    private int strikes;
    private int balls;

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public Score(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public void setStrikes(int strikes, int balls){
        this.strikes = strikes;
        this.balls = balls;
    }
}
