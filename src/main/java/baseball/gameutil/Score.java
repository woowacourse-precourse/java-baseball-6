package baseball.gameutil;

public class Score {
    private Integer strike;
    private Integer ball;

    public Score (Integer ball, Integer strike){
        this.ball = ball;
        this.strike = strike;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
