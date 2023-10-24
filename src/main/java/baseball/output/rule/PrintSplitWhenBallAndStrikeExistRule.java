package baseball.output.rule;

import baseball.game.BallAndStrike;

public class PrintSplitWhenBallAndStrikeExistRule implements PrintBaseBallResultOutputRule {
    private static final String STRING_SPLIT = " ";

    private final BallAndStrike ballAndStrike;

    public PrintSplitWhenBallAndStrikeExistRule(final BallAndStrike ballAndStrike) {
        this.ballAndStrike = ballAndStrike;
    }

    @Override
    public void print() {
        if (bothBallAndStrikeAreGreaterThanZero()) {
            System.out.print(STRING_SPLIT);
        }
    }

    private boolean bothBallAndStrikeAreGreaterThanZero() {
        return ballAndStrike.ball() > 0 && ballAndStrike.strike() > 0;
    }
}
