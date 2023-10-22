package baseball.model;

public class BaseballGameCounts {
    private int strikes;
    private int balls;

    protected BaseballGameCounts() {
    }

    public static BaseballGameCounts createBaseballGameCounts() {
        return new BaseballGameCounts();
    }

    public boolean isWinCondition() {
        return this.strikes == 3;
    }



    public void resetCounts() {
        this.strikes = 0;
        this.balls = 0;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

}
