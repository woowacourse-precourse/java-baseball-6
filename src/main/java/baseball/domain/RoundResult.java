package baseball.domain;

public class RoundResult {

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String SPACE = " ";
    private static final int ZERO = 0;
    private static final int THREE_STRIKE = 3;

    private final int strike;
    private final int ball;

    protected RoundResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static RoundResult of(Balls target, Balls user) {
        return new RoundResult(target.countStrike(user), target.countBall(user));
    }

    public String getResult() {
        if (strike == ZERO && ball == ZERO) {
            return NOTHING;
        }
        if (ball != ZERO && strike != ZERO) {
            return ball + BALL + SPACE + strike + STRIKE;
        }
        if (ball != ZERO) {
            return ball + BALL;
        }
        if (strike != ZERO) {
            return strike + STRIKE;
        }
        return null;
    }


    public boolean isLose() {
        return strike != THREE_STRIKE;
    }
}
