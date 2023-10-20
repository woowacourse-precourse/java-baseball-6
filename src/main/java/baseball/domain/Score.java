package baseball.domain;

public class Score {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setScore(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
    }

//    public Score(int strike, int ball) {
//        this.strike = strike;
//        this.ball = ball;
//    }
}
