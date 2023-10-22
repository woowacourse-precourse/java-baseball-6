package baseball;

public class Result {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getResultString() {
        if (strike == 0 && ball == 0) {
            return NOTHING;
        }
        else if (strike > 0 && ball == 0) {
            return strike + STRIKE;
        }
        else if (ball > 0 && strike == 0) {
            return ball + BALL;
        }
        return ball + BALL + " " + strike + STRIKE;
    }
}