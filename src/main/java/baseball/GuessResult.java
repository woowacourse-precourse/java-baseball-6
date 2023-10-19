package baseball;

public class GuessResult {
    private int strikes;
    private int balls;

    public GuessResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }
}
