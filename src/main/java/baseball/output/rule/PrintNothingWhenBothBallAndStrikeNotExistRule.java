package baseball.output.rule;

import baseball.game.BallAndStrike;

public class PrintNothingWhenBothBallAndStrikeNotExistRule implements PrintBaseBallResultOutputRule {
    private static final String STRING_NOTHING = "낫싱";

    private final BallAndStrike ballAndStrike;

    public PrintNothingWhenBothBallAndStrikeNotExistRule(final BallAndStrike ballAndStrike) {
        this.ballAndStrike = ballAndStrike;
    }

    @Override
    public void print() {
        if (bothBallAndStrikeAreZero()) {
            System.out.print(STRING_NOTHING);
        }
    }

    private boolean bothBallAndStrikeAreZero() {
        return ballAndStrike.ball() == 0 && ballAndStrike.strike() == 0;
    }
}
