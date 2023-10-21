package baseball.gameutil;

public class Score {
    public Integer strike;
    public Integer ball;

    private Score (Integer strike, Integer ball){
        this.strike = strike;
        this.ball = ball;
    }

    static Score fromNumber(Integer strike, Integer ball){
        return new Score(strike, ball);
    }
}
