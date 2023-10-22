package baseball.modules.score;

import baseball.modules.player.Player;
import java.util.Map;

public class BaseballScore implements Score{
    private final Map<BaseBallScoreType, Integer> score;

    public BaseballScore() {
        this.score = BaseBallScoreType.getInitScore();
    }

    public BaseballScore(final Map<BaseBallScoreType, Integer> score) {
        this.score = score;
    }

    @Override
    public Score calculate(final Player computer, final Player human) {
        return new BaseballScore(computer.compare(human));
    }

    @Override
    public Map<BaseBallScoreType, Integer> getScore() {
        return score;
    }
}
