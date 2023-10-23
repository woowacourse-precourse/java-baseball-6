package baseball.modules.score;

import baseball.modules.player.Player;
import java.util.Map;

public abstract class AbstractScore implements Score{

    private final Map<? extends ScoreType, Integer> score;

    public AbstractScore(final Map<? extends ScoreType, Integer> score) {
        this.score = score;
    }

    public abstract Score calculate(final Player computer, final Player human);

    @Override
    public Map<? extends ScoreType, Integer> getScore(){
        return this.score;
    }
}
