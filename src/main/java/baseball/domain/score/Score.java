package baseball.domain.score;

public class Score {
    private final int ball;
    private final int strike;
    private StringFormatter stringFormatter;

    private Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Score of(int ball, int strike) {
        return new Score(ball, strike);
    }

    public String format() {
        selectFormatter();
        return stringFormatter.format(ball, strike);
    }

    private void selectFormatter() {
        checkBothAreZero();
        checkOnlyBall();
        checkOnlyStrike();
        checkBallAndStrike();
    }

    private void checkBothAreZero() {
        if (bothAreZero(ball, strike)) {
            stringFormatter = new BothZeroFormatter();
        }
    }

    private void checkOnlyBall() {
        if (onlyBall(ball, strike)) {
            stringFormatter = new OnlyBallFormatter();
        }
    }

    private void checkOnlyStrike() {
        if (onlyStrike(ball, strike)) {
            stringFormatter = new OnlyStrikeFormatter();
        }
    }

    private void checkBallAndStrike() {
        if (ballAndStrike(ball, strike)) {
            stringFormatter = new BallAndStrikeFormatter();
        }
    }

    private static boolean bothAreZero(int ball, int strike) {
        return isZero(ball) && isZero(strike);
    }

    private static boolean onlyBall(int ball, int strike) {
        return !isZero(ball) && isZero(strike);
    }

    private static boolean onlyStrike(int ball, int strike) {
        return isZero(ball) && !isZero(strike);
    }

    private boolean ballAndStrike(int ball, int strike) {
        return !isZero(ball) && !isZero(strike);
    }

    private static boolean isZero(int number) {
        return number == 0;
    }
}
