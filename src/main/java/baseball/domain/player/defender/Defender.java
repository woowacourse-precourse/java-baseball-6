package baseball.domain.player.defender;

import baseball.domain.player.Player;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.value.Ball;
import java.util.List;

public interface Defender extends Player {

	Results compareBalls(List<Ball> balls);
}
