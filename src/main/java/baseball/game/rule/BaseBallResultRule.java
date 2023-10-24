package baseball.game.rule;

import baseball.game.BallAndStrike;
import baseball.game.BaseBallNumberGroup;

public interface BaseBallResultRule {
    BallAndStrike apply(final BaseBallNumberGroup answer, final BaseBallNumberGroup user);
}
