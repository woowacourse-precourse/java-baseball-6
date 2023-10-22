package baseball.gameutil;

public class Score {
    private Integer strike;
    private Integer ball;

    private Score (Integer strike, Integer ball){
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    static Score fromNumber(Integer strike, Integer ball){
        return new Score(strike, ball);
    }
}
