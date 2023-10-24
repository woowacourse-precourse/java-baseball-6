package baseball;

public class Score {
    int strike;
    int ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
    public void countStrike(){
        this.strike++;
    }
    public void countBall(){
        this.ball++;
    }
}
