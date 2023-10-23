package baseball.modules.player;

import baseball.modules.score.ScoreType;
import java.util.List;
import java.util.Map;

public interface Player {
    List<Integer> getNumbers();

    Map<? extends ScoreType, Integer> compare(final Player player);
}
