package baseball.domain.player.defender;

import baseball.domain.player.Player;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.value.Balls;

public interface Defender extends Player {

	Results defend(Balls balls);
}
