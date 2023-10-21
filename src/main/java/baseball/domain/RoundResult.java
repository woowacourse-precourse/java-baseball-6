package baseball.domain;

public class RoundResult {

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String SPACE = " ";
    private static final int ZERO = 0;

    private final String result;

    protected RoundResult(String result) {
        this.result = result;
    }

    public static RoundResult of(Balls computer, Balls user) {
        int numberOfStrike = computer.countStrike(user);
        int numberOfBall = computer.countBall(user);

        if (computer.isNothing(user)) {
            return new RoundResult(NOTHING);
        }
        if (numberOfBall != ZERO && numberOfStrike != ZERO) {
            return new RoundResult(numberOfBall + BALL + SPACE + numberOfStrike + STRIKE);
        }
        if (numberOfBall != ZERO) {
            return new RoundResult(numberOfBall + BALL);
        }
        if (numberOfStrike != ZERO) {
            return new RoundResult(numberOfStrike + STRIKE);
        }
        return null;
    }

    @Override
    public String toString() {
        return result;
    }
}
