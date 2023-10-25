package baseball;

public class Result {
    private final int strikes;
    private final int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }


    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
