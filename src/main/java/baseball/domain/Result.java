package baseball.domain;

public class Result {
    private int ball;
    private int strike;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public String getOutputMessage() {
        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else if (ball > 0) {
            return ball + "볼";
        } else if (strike > 0) {
            return strike + "스트라이크";
        }
        return "낫싱";
    }
}