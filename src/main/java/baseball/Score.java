package baseball;

public class Score {
    int strike;
    int ball;
    public Score() {
        strike = 0;
        ball = 0;
    }
    public void reset() {
        strike = 0;
        ball = 0;
    }
    public int getStrike() { return strike; }
    public int getBall() { return ball; }
    public void setStrike(int strike) { this.strike = strike; }
    public void setBall(int ball) { this.ball = ball; }
}
