package baseball.domain;

public class RoundResult {

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String SPACE = " ";
    private static final int ZERO = 0;
    private static final int THREE_STRIKE = 3;

    private final int numberOfStrike;
    private final int numberOfBall;

    protected RoundResult(int numberOfStrike, int numberOfBall) {
        this.numberOfStrike = numberOfStrike;
        this.numberOfBall = numberOfBall;
    }

    public static RoundResult of(Balls target, Balls user) {
        return new RoundResult(target.countStrike(user), target.countBall(user));
    }

    public String getResult() {
        if (numberOfStrike == ZERO && numberOfBall == ZERO) {
            return NOTHING;
        }
        if (numberOfBall != ZERO && numberOfStrike != ZERO) {
            return numberOfBall + BALL + SPACE + numberOfStrike + STRIKE;
        }
        if (numberOfBall != ZERO) {
            return numberOfBall + BALL;
        }
        if (numberOfStrike != ZERO) {
            return numberOfStrike + STRIKE;
        }
        return null;
    }


    public boolean isLose() {
        return numberOfStrike != THREE_STRIKE;
    }
}
