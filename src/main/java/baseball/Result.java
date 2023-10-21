package baseball;

public class Result {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String SPACE = " ";

    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {
        if (ball > 0 && strike > 0) {
            return ball + BALL + SPACE + strike + STRIKE;
        } else if (strike > 0) {
            return strike + STRIKE;
        } else if (ball > 0) {
            return ball + BALL;
        }
        return NOTHING;
    }
}
