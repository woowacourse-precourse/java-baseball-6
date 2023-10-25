package baseball;

public class Score {
    private Integer strike;
    private Integer ball;

    public Score() {
        this.strike = 0;
        this.ball = 0;
    }

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

    public void plusStrike() {
        this.strike += 1;
    }

    public void plusBall() {
        this.ball += 1;
    }

    public String explainScore() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        String result = "";
        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }

        return result.trim();
    }

}
