package baseball.modules.player;

import baseball.modules.score.BaseBallScoreType;
import java.util.List;
import java.util.Map;

public interface Player {
    List<Integer> getNumbers();

    Map<BaseBallScoreType, Integer> compare(final Player player);
}
