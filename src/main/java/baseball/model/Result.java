package baseball.model;

public class Result {
    private static final String NOTHING = "낫싱";
    private static final String BALL_FORMAT = "%d볼";
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String BALL_STRIKE_FORMAT = "%d볼 %d스트라이크";
    private static final int ZERO = 0;
    private final int ball;
    private final int strike;

    private Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Result of(Numbers computer, Numbers user) {
        int ball = computer.countBall(user);
        int strike = computer.countStrike(user);
        return new Result(ball, strike);
    }

    public String getHint() {
        String hint = NOTHING;
        if (ball > ZERO && strike == ZERO) {
            hint = String.format(BALL_FORMAT, ball);
        }
        if (ball == ZERO && strike > ZERO) {
            hint = String.format(STRIKE_FORMAT, strike);
        }
        if (ball > ZERO && strike > ZERO) {
            hint = String.format(BALL_STRIKE_FORMAT, ball, strike);
        }
        return hint;
    }

    public boolean isLessThanThreeStrikes() {
        return strike < Numbers.SIZE;
    }
}
