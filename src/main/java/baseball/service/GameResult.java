package baseball.service;

public class GameResult {

    private int strike;
    private int ball;
    private int nothing;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void addStrikeCount(){
        this.strike += 1;
    }

    public void addBallCount() {
        this.ball += 1;
    }

    public void addNothingCount() {
        this.ball += 1;
    }
}
