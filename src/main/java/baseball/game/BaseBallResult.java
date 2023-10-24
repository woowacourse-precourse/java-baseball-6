package baseball.game;

import baseball.game.rule.BallRule;
import baseball.game.rule.StrikeRule;

public class BaseBallResult {
    private BallAndStrike ballAndStrike;

    public BaseBallResult(final BaseBallNumberGroup answer, final BaseBallNumberGroup user) {
        ballAndStrike = new BallAndStrike(
                getBallCount(answer, user),
                getStrikeCount(answer, user)
        );
    }

    private int getBallCount(final BaseBallNumberGroup answer, final BaseBallNumberGroup user) {
        final BallAndStrike result = new BallRule().apply(answer, user);
        return result.ball();
    }

    private int getStrikeCount(final BaseBallNumberGroup answer, final BaseBallNumberGroup user) {
        final BallAndStrike result = new StrikeRule().apply(answer, user);
        return result.strike();
    }

    public boolean isAllStrike() {
        return ballAndStrike.strike() == GameConstants.SIZE_RANDOM_NUMBER;
    }

    public BallAndStrike getBallAndStrike() {
        return ballAndStrike;
    }
}
