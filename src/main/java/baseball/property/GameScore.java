package baseball.property;

public class GameScore {
    private int ball_count;
    private int strike_count;

    public GameScore(int ball_count, int strike_count) {
        this.ball_count = ball_count;
        this.strike_count = strike_count;
    }

    public int getBall_count(){
        return this.ball_count;
    }

    public int getStrike_count(){
        return this.strike_count;
    }

}
