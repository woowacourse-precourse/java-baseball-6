package baseball.modules.score;

import baseball.modules.player.Player;
import java.util.Map;

public interface Score {

    Score calculate(final Player computer, final Player human);

    Map<? extends ScoreType, Integer> getScore();

}
