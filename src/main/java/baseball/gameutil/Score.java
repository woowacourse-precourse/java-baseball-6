package baseball.gameutil;

public class Score {
    private int strike;
    private int ball;

    public Score (int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
