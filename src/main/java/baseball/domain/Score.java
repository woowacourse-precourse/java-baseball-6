package baseball.domain;

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

    public StringFormatter selectFormatter() {
        selectFormatter(ball, strike);
        return stringFormatter;
    }

    private void selectFormatter(int ball, int strike) {
        if (bothAreZero(ball, strike)) {
            stringFormatter = new BothZeroFormatter();
        }

        if (onlyBall(ball, strike)) {
            stringFormatter = new OnlyBallFormatter();
        }

        if (onlyStrike(ball, strike)) {
            stringFormatter = new OnlyStrikeFormatter();
        }

        if (ballAndStrike(ball, strike)) {
            stringFormatter = new BallAndStrikeFormatter();
        }
    }

    private static boolean bothAreZero(int ball, int strike) {
        return ball == 0 && strike == 0;
    }

    private static boolean onlyBall(int ball, int strike) {
        return ball != 0 && strike == 0;
    }

    private static boolean onlyStrike(int ball, int strike) {
        return ball == 0 && strike != 0;
    }

    private boolean ballAndStrike(int ball, int strike) {
        return ball != 0 && strike != 0;
    }
}
