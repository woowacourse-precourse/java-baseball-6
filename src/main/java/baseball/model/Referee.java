package baseball.model;

public class Referee {
    private int strikes;
    private int balls;

    public Referee() {
        this.strikes = 0;
        this.balls = 0;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes() {
        this.strikes += 1;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls() {
        this.balls += 1;
    }
}
