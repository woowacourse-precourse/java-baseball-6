package baseball.domain;

public class GameResult {
    Integer strike;
    Integer ball;
    Boolean success;

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
