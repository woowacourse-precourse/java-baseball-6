package baseball.modules.score;

import baseball.modules.player.Player;
import java.util.Map;

public class BaseballScore extends AbstractScore{

    public BaseballScore() {
        super(BaseBallScoreType.getInitScore());
    }

    public BaseballScore(final Map<? extends ScoreType, Integer> score) {
        super(score);
    }

    @Override
    public Score calculate(final Player computer, final Player human) {
        return new BaseballScore(computer.compare(human));
    }
}
