package baseball;

public class GameResult {

    private Integer strike;

    private Integer ball;

    public void setStrike(Integer strikeNum) {
        this.strike = strikeNum;
    }

    public void setBall(Integer ballNum) {
        this.ball = ballNum;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
