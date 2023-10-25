package baseball.game.model;

public class Result {
    private Integer strike;
    private Integer ball;

    public Integer getStrike() {
        return strike;
    }

    public void setStrike(Integer strike) {
        this.strike = strike;
    }

    public Integer getBall() {
        return ball;
    }

    public void setBall(Integer ball) {
        this.ball = ball;
    }

    public Result(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String toMessage() {
        if (strike == 3) {
            return "3스트라이크";
        }
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0 && ball != 0) {
            return Integer.toString(ball) + "볼";
        }
        if (strike != 0 && ball == 0) {
            return Integer.toString(strike) + "스트라이크";
        }
        return Integer.toString(ball) + "볼" + " " + Integer.toString(strike) + "스트라이크";
    }

    public boolean isThreeStrike() {
        if (strike == 3) {
            return true;
        }
        return false;
    }
}
