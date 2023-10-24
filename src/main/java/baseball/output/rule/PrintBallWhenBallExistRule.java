package baseball.output.rule;

import baseball.game.BallAndStrike;

public class PrintBallWhenBallExistRule implements PrintBaseBallResultOutputRule {
    private static final String STRING_BALL_PREFIX = "볼";

    private final BallAndStrike ballAndStrike;

    public PrintBallWhenBallExistRule(final BallAndStrike ballAndStrike) {
        this.ballAndStrike = ballAndStrike;
    }

    @Override
    public void print() {
        if (!isBallGreaterThanZero()) {
            return;
        }

        System.out.print(ballAndStrike.ball() + STRING_BALL_PREFIX);
    }

    private boolean isBallGreaterThanZero() {
        return ballAndStrike.ball() > 0;
    }
}
