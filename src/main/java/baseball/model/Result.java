package baseball.model;

public class Result {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    private int ball = 0;
    private int strike = 0;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
    
    public String toString() {
        String result = NOTHING;

        if (ball == 0 && strike == 0) {
            return NOTHING;
        } else if (strike == 3 && ball == 0) {
            return strike + STRIKE;
        } else if (ball > 0) {
            result = ball + BALL;
            if (strike > 0) {
                result += " " + strike + STRIKE;
            }
            return result;
        }
        return result;
    }
}
