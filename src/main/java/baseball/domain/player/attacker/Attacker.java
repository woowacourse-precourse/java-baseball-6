package baseball.domain.player.attacker;

import baseball.domain.player.Player;
import baseball.domain.player.value.Ball;
import baseball.exception.rutime.NotInitializeBallException;
import java.util.List;

public interface Attacker extends Player {

    List<Ball> getBalls() throws NotInitializeBallException;
}
