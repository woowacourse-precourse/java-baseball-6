package baseball.output.rule;

import baseball.game.BallAndStrike;

public class PrintStrikeWhenStrikeExistRule implements PrintBaseBallResultOutputRule {
    private static final String STRING_STRIKE_PREFIX = "스트라이크";

    private final BallAndStrike ballAndStrike;

    public PrintStrikeWhenStrikeExistRule(final BallAndStrike ballAndStrike) {
        this.ballAndStrike = ballAndStrike;
    }

    @Override
    public void print() {
        if (!isStrikeGreaterThanZero()) {
            return;
        }

        System.out.print(ballAndStrike.strike() + STRING_STRIKE_PREFIX);
    }

    private boolean isStrikeGreaterThanZero() {
        return ballAndStrike.strike() > 0;
    }
}
